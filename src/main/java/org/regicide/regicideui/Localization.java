package org.regicide.regicideui;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.LocalizationBundle;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Localization system of the plugin.
 */
public final class Localization {

    private final static Map<String, LocalizationBundle> REFERENCE_LOCALIZATION_MAP = new HashMap<>();
    private final static Map<String, LocalizationBundle> OVERRIDE_LOCALIZATION_MAP = new HashMap<>();

    private static String defaultLocaleTag;

    private static Plugin plugin;
    private static boolean isClientOriented;

    /**
     * Setups plugin's localization.
     *
     * @param plugin The plugin for which localization is created.
     * @param isClientOriented Will users receive messages from the plugin depending on their language or will they receive default messages
     * @param path The path to the localization files directory <b>NOTE: Without specified plugin's data folder and directory name</b>.
     * @param dir The directory name of the localization files.
     * @param defaultLocaleTag The default localization of the plugin.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void setup(@NotNull final Plugin plugin, boolean isClientOriented, @NotNull final String path,
                             @NotNull final String dir, @NotNull final String defaultLocaleTag)
            throws IOException, InvalidConfigurationException {

        Localization.plugin = plugin;
        Localization.isClientOriented = isClientOriented;
        Localization.defaultLocaleTag = defaultLocaleTag;

        File dFolder = plugin.getDataFolder();

        String rPath, oPath;
        rPath = dFolder + File.separator + path + File.separator + dir;
        oPath = dFolder + File.separator + path + File.separator + "override";

        File rFile = new File(rPath);
        File oFile = new File(oPath);

        rFile.mkdirs();
        oFile.mkdirs();

        loadToDataFolder(path, dir);
        loadReference(rFile);
        loadOverride(oFile);
    }

    /**
     * Loads all plugin's localization to dataFolder
     */
    private static void loadToDataFolder(@NotNull final String locPath, @NotNull final String locDir) throws IOException {
        Matcher m = Pattern.compile("plugins/.+\\.jar$")
                .matcher(plugin.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        String plPath = null;
        while (m.find())
            plPath = m.group(0);

        assert plPath != null;
        try (ZipFile pJAR = new ZipFile(plPath)) {
            String p = (locPath.replaceAll("\\\\", "\\/")) + "/" + locDir;
            Pattern m2 = Pattern.compile("^"+ p +"/.+$");

            Enumeration<? extends ZipEntry> zipEntries = pJAR.entries();
            while (zipEntries.hasMoreElements()) {
                String fileName = zipEntries.nextElement().getName();
                if (m2.matcher(fileName).find())
                    plugin.saveResource(fileName, true);
            }
        }
    }

    /**
     * @param dir The directory of the localization references.
     * @throws IOException if an error occurred when reading from the input stream.
     */
    @SuppressWarnings("ConstantConditions")
    private static void loadReference(@NotNull final File dir) throws IOException {
        if (dir.listFiles() == null || dir.listFiles().length == 0)
            return;

        for (File bundleFile : dir.listFiles()) {
            LocalizationBundle locBundle = new LocalizationBundle(bundleFile);
            REFERENCE_LOCALIZATION_MAP.put(locBundle.getRaw("locale.tag"), locBundle);
        }
    }

    /**
     * Loads override localization from plugin's data folder.
     *
     * @param dir The directory of the localization references.
     * @throws IOException if an error occurred when reading from the input stream.
     */
    @SuppressWarnings("ConstantConditions")
    private static void loadOverride(@NotNull final File dir) throws IOException {
        if (dir.listFiles() == null || dir.listFiles().length == 0)
            return;

        plugin.getLogger().info("Override localizations detected:");
        for (File bundleFile : dir.listFiles()) {
            LocalizationBundle locBundle = new LocalizationBundle(bundleFile);
            String localeTag = locBundle.getRaw("locale.tag");
            OVERRIDE_LOCALIZATION_MAP.put(localeTag, locBundle);
            plugin.getLogger().info(localeTag + " – " + locBundle.getRaw("locale.name") + " by " + locBundle.getRaw("author"));
        }
    }

    /**
     * @param key The key of the localized message.
     * @param localeTag The locale tag.
     * @return The string of the localization by specified locale code.
     * <b>NOTE:</b> Firstly method will return override localization string by locale code, if
     * it's null this method will return reference localization string by locale code, if
     * it's null this method will return default reference localization specified in setup of {@link Localization}
     * and if it's null too then this method will return the specified key.
     */
    private static String getClientOriented(@NotNull final String key, @NotNull final String localeTag) {
        // Override-client-oriented? -> Reference-client-oriented? -> Reference-default? -> key
        LocalizationBundle bundle;
        String msg;

        bundle = OVERRIDE_LOCALIZATION_MAP.get(localeTag);
        if (bundle != null) {
            msg = bundle.getRaw(key);
            if (msg != null)
                return msg;
        }
        bundle = REFERENCE_LOCALIZATION_MAP.get(localeTag);
        if (bundle != null) {
            msg = bundle.getRaw(key);
            if (msg != null)
                return msg;
        }
        bundle = REFERENCE_LOCALIZATION_MAP.get(defaultLocaleTag);
        if (bundle != null) {
            msg = bundle.getRaw(key);
            if (msg != null)
                return msg;
        }
        return key;
    }

    /**
     * @param key The key of the localized message.
     * @return The string of the localization by specified locale code.
     * <b>NOTE:</b> Firstly method will return override default localization string, if
     * it's null this method will return reference default localization string
     * and if it's null too then this method will return the specified key.
     */
    public static String get(@NotNull final String key) {
        // Override-default? -> Reference-default? -> key
        LocalizationBundle bundle;
        String msg;

        bundle = OVERRIDE_LOCALIZATION_MAP.get(defaultLocaleTag);
        if (bundle != null) {
            msg = bundle.getRaw(key);
            if (msg != null)
                return msg;
        }
        bundle = REFERENCE_LOCALIZATION_MAP.get(defaultLocaleTag);
        if (bundle != null) {
            msg = bundle.getRaw(key);
            if (msg != null)
                return msg;
        }
        return key;
    }

    /**
     *
     * @param key The key of the localized message.
     * @param localeTag The string of the localization by specified locale code.
     * @return The string of the localization by specified locale code.
     */
    public static String get(@NotNull final String key, @NotNull final String localeTag) {
        if (isClientOriented)
            return getClientOriented(key, localeTag);
        else return get(key);
    }
}
package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final HiltLibraryAccessors laccForHiltLibraryAccessors = new HiltLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KtorLibraryAccessors laccForKtorLibraryAccessors = new KtorLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for junit (junit:junit)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit");
    }

        /**
         * Creates a dependency provider for material (com.google.android.material:material)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() {
            return create("material");
    }

        /**
         * Creates a dependency provider for zxing (com.google.zxing:core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getZxing() {
            return create("zxing");
    }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at hilt
     */
    public HiltLibraryAccessors getHilt() {
        return laccForHiltLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Returns the group of libraries at ktor
     */
    public KtorLibraryAccessors getKtor() {
        return laccForKtorLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxEspressoLibraryAccessors laccForAndroidxEspressoLibraryAccessors = new AndroidxEspressoLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() {
                return create("androidx.appcompat");
        }

            /**
             * Creates a dependency provider for constraintlayout (androidx.constraintlayout:constraintlayout)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConstraintlayout() {
                return create("androidx.constraintlayout");
        }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() {
                return create("androidx.junit");
        }

            /**
             * Creates a dependency provider for recyclerview (androidx.recyclerview:recyclerview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRecyclerview() {
                return create("androidx.recyclerview");
        }

        /**
         * Returns the group of libraries at androidx.activity
         */
        public AndroidxActivityLibraryAccessors getActivity() {
            return laccForAndroidxActivityLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() {
            return laccForAndroidxCoreLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.espresso
         */
        public AndroidxEspressoLibraryAccessors getEspresso() {
            return laccForAndroidxEspressoLibraryAccessors;
        }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for activity (androidx.activity:activity)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("androidx.activity");
        }

            /**
             * Creates a dependency provider for ktx (androidx.activity:activity-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.activity.ktx");
        }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.core.ktx");
        }

    }

    public static class AndroidxEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("androidx.espresso.core");
        }

    }

    public static class HiltLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for hilt (com.google.dagger:hilt-android-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("hilt");
        }

            /**
             * Creates a dependency provider for android (com.google.dagger:hilt-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("hilt.android");
        }

            /**
             * Creates a dependency provider for compiler (com.google.dagger:hilt-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() {
                return create("hilt.compiler");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinTestLibraryAccessors laccForKotlinTestLibraryAccessors = new KotlinTestLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlin.test
         */
        public KotlinTestLibraryAccessors getTest() {
            return laccForKotlinTestLibraryAccessors;
        }

    }

    public static class KotlinTestLibraryAccessors extends SubDependencyFactory {

        public KotlinTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (org.jetbrains.kotlin:kotlin-test-junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() {
                return create("kotlin.test.junit");
        }

    }

    public static class KtorLibraryAccessors extends SubDependencyFactory {
        private final KtorServerLibraryAccessors laccForKtorServerLibraryAccessors = new KtorServerLibraryAccessors(owner);

        public KtorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (io.ktor:ktor-server-core-jvm)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("ktor.core");
        }

        /**
         * Returns the group of libraries at ktor.server
         */
        public KtorServerLibraryAccessors getServer() {
            return laccForKtorServerLibraryAccessors;
        }

    }

    public static class KtorServerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public KtorServerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for server (io.ktor:ktor-server-freemarker-jvm)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("ktor.server");
        }

            /**
             * Creates a dependency provider for netty (io.ktor:ktor-server-netty-jvm)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNetty() {
                return create("ktor.server.netty");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: activity (1.8.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivity() { return getVersion("activity"); }

            /**
             * Returns the version associated to this alias: agp (8.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAgp() { return getVersion("agp"); }

            /**
             * Returns the version associated to this alias: appcompat (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppcompat() { return getVersion("appcompat"); }

            /**
             * Returns the version associated to this alias: constraintlayout (2.1.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getConstraintlayout() { return getVersion("constraintlayout"); }

            /**
             * Returns the version associated to this alias: coreKtx (1.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoreKtx() { return getVersion("coreKtx"); }

            /**
             * Returns the version associated to this alias: dokka (1.9.20)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDokka() { return getVersion("dokka"); }

            /**
             * Returns the version associated to this alias: espressoCore (3.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEspressoCore() { return getVersion("espressoCore"); }

            /**
             * Returns the version associated to this alias: hilt (2.48.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHilt() { return getVersion("hilt"); }

            /**
             * Returns the version associated to this alias: junit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: junitVersion (1.1.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunitVersion() { return getVersion("junitVersion"); }

            /**
             * Returns the version associated to this alias: kotlin (1.9.20)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: kotlinTestJunit (1.8.22)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinTestJunit() { return getVersion("kotlinTestJunit"); }

            /**
             * Returns the version associated to this alias: ktor (2.3.9)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtor() { return getVersion("ktor"); }

            /**
             * Returns the version associated to this alias: material (1.11.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterial() { return getVersion("material"); }

            /**
             * Returns the version associated to this alias: recyclerview (1.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRecyclerview() { return getVersion("recyclerview"); }

            /**
             * Returns the version associated to this alias: zxing (3.4.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getZxing() { return getVersion("zxing"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for androidApplication to the plugin id 'com.android.application'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroidApplication() { return createPlugin("androidApplication"); }

            /**
             * Creates a plugin provider for ioKtor to the plugin id 'io.ktor.plugin'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getIoKtor() { return createPlugin("ioKtor"); }

            /**
             * Creates a plugin provider for jetbrainsDokka to the plugin id 'org.jetbrains.dokka'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJetbrainsDokka() { return createPlugin("jetbrainsDokka"); }

            /**
             * Creates a plugin provider for jetbrainsKotlinAndroid to the plugin id 'org.jetbrains.kotlin.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJetbrainsKotlinAndroid() { return createPlugin("jetbrainsKotlinAndroid"); }

            /**
             * Creates a plugin provider for ksp to the plugin id 'com.google.devtools.ksp'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKsp() { return createPlugin("ksp"); }

    }

}

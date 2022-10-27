plugins {
    id("java")
    id("net.minecrell.plugin-yml.bukkit") version("0.5.2")
    id("com.github.johnrengelman.shadow") version("7.1.2")
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.1-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    implementation(project(":api"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}
java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

bukkit {
    main = "team.devblook.blootils.Blootils"
    name = project.name
    apiVersion = "1.13"
    version = "${project.version}"

    author = "DevBlook Team"
    softDepend = listOf("Vault", "PlaceholderAPI")

    commands {
        register("blootils") {
            description = "Main command of blootils plugin"
            aliases = listOf("butils", "btils", "bts")
            permission = "blootils.command.blootils"
            usage = "/blootils help"
        }
        register("fly") {
            description = "Active FLy"
            permission = "blootils.command.fly"
            usage = "/fly"
        }
        register("feed") {
            description = "Refill Food"
            permission = "blootils.command.food"
            usage = "/feed"
        }
        register("heal") {
            description = "Recover all life"
            permission = "blootils.command.heal"
            usage = "/heal"
        }
        register("sign") {
            description = "Edit sign looking you"
            permission = "blootils.command.sign"
            usage = "/sign edit"
        }
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

plugins {
    id("java")
    id("net.minecrell.plugin-yml.bukkit") version("0.5.2")
    id("com.github.johnrengelman.shadow") version("7.1.2")
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.1-R0.1-SNAPSHOT")
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
        register("food") {
            description = "Refill Food"
            permission = "blootils.command.food"
            usage = "/flood"
        }
        register("heal") {
            description = "Recover all life"
            permission = "blootils.command.heal"
            usage = "/heal"
        }
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

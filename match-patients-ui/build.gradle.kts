import com.github.gradle.node.npm.task.NpxTask
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.Delete

plugins {
  id("com.github.node-gradle.node") version "7.1.0"
	kotlin("jvm") version "1.9.25"
}

repositories {
    mavenCentral()
}
node {
  version = "22.12.0"
  npmVersion = "10.5.0"
  download = true
}

val deleteStaticFilesTask = tasks.register<Delete>("deleteStaticFiles") {
	delete("${project.buildDir}/../../match-patients-api/src/main/resources/static/")
}

val createStaticDirectoryTask = tasks.register<Delete>("createStaticDirectory") {
	mkdir("${project.buildDir}/../../match-patients-api/src/main/resources/static/")
}

val buildWebappTask = tasks.register<NpxTask>("buildWebapp") {
	project.logger.quiet("buildWebappTask")
	dependsOn(deleteStaticFilesTask)
	dependsOn(createStaticDirectoryTask)
	dependsOn("npmInstall")
  command.set("ng")
  args.set(listOf("build"))
  inputs.dir(project.fileTree("src").exclude("**/*.spec.ts"))
  inputs.dir("node_modules")
  inputs.files("angular.json", ".browserslistrc", "tsconfig.json", "tsconfig.app.json")
  outputs.dir("${project.buildDir}/../../match-patients-api/src/main/resources/static/")
}

tasks.named("build") {
	dependsOn(buildWebappTask)
}
plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.8.0");
    implementation("org.slf4j:slf4j-api:1.7.25");

}

tasks.test {
    useTestNG();
}
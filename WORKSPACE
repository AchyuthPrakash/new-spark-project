load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "4.0"
RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.jsoup:jsoup:1.13.1",
        "org.mongodb:mongo-java-driver:3.12.8",
        "com.sparkjava:spark-core:2.9.3",
        "org.apache.httpcomponents:httpclient:4.5.13",        
    ],
    repositories = [
        # Private repositories are supported through HTTP Basic auth
        "https://repo1.maven.org/maven2/",
    ],
)

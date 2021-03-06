griffon.project.dependency.resolution = {
    inherits("global")
    log "warn"
    repositories {
        griffonHome()
        // pluginDirPath is only available when installed
        String basePath = pluginDirPath? "${pluginDirPath}/" : ''
        flatDir name: "jideBuilderPluginLib", dirs: ["${basePath}lib"]
        mavenCentral()
        mavenRepo 'http://repository.codehaus.org'
        mavenRepo 'http://repository.sonatype.org/content/groups/public'
    }
    dependencies {
        compile('org.codehaus.griffon:jidebuilder:6.0') {
            excludes 'groovy-all', 'svg-salamander'
        }
        compile 'com.kitfox.svg:svg-salamander:1.1'
    }
}

griffon {
    doc {
        logo = '<a href="http://griffon.codehaus.org" target="_blank"><img alt="The Griffon Framework" src="../img/griffon.png" border="0"/></a>'
        sponsorLogo = "<br/>"
        footer = "<br/><br/>Made with Griffon (@griffon.version@)"
    }
}

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
          'org.springframework',
          'org.apache.karaf',
          'groovyx.net'
    warn  'griffon'
}

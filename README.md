run
`./gradlew :acceptance:test` and you should see

```
> Task :acceptance:test

AcceptanceTest > start() FAILED
    java.lang.IllegalStateException at DefaultCacheAwareContextLoaderDelegate.java:142
        Caused by: org.springframework.beans.factory.BeanCreationException at AbstractAutowireCapableBeanFactory.java:1770
            Caused by: liquibase.exception.ChangeLogParseException at XMLChangeLogSAXParser.java:128
                Caused by: java.io.IOException at ResourceAccessor.java:195
```

and the root cause is

```
Caused by: java.io.IOException: Found 2 files with the path 'classpath:db/changelog/db.changelog-master.xml':
    - jar:file:/workspace/classpath-error/app/build/libs/app-0.0.1-SNAPSHOT-plain.jar!/db/changelog/db.changelog-master.xml
    - file:/workspace/classpath-error/app/build/resources/main/db/changelog/db.changelog-master.xml
  Search Path: 
    - Spring classpath
  You can limit the search path to remove duplicates with the liquibase.searchPath setting. Or, if you KNOW these are the exact same file you can set liquibase.duplicateFileMode=WARN.
	at liquibase.resource.ResourceAccessor.get(ResourceAccessor.java:195)
	at liquibase.parser.core.xml.XMLChangeLogSAXParser.parseToNode(XMLChangeLogSAXParser.java:74)
	... 123 more
```

the kotlin version can be changed in [build.gradle.kts](./build.gradle.kts)
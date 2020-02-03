#Ezframework
[![Download](https://api.bintray.com/packages/kingcjy/ezframework/ezframework-core/images/download.svg) ](https://bintray.com/kingcjy/ezframework/ezframework-core/_latestVersion)


Ezframework는 Spigot에서 사용할 수 있는 IOC 기반 커맨드 프레임워크입니다.


## 사용 방법


###Maven

```xml
<dependencies>
    <dependency>
      <groupId>io.github.kingcjy</groupId>
      <artifactId>ezframework-core</artifactId>
      <version>1.0.3</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <compilerArgs>
                    <arg>-parameters</arg>
                </compilerArgs>
            </configuration>
        </plugin>
    </plugins>
</build>
```

###Gradle
```groovy
dependencies {
    implementation 'io.github.kingcjy:ezframework-core:1.0.3'
}

compileJava.options.compilerArgs = ['-parameters']
```

### 사용방법
```java
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Ezplugin.run(this);
    }
}
```

```java
@CommandService("message")
public class MessageCommand {

// /message <message>
    @Command("<message>")
    public void broadcastMessage(@PathVariable String message) {
        Bukkit.broadcastMessage(message);
    }

// /message <playerName> <message>
    @Command("<playerName> <message>")
    public void messageToPlayer(@PathVariable String playerName, @PathVariable String message) {
        Player player = Bukkit.getPlayer(playerName);
        player.sendMessage(message);
    }
}
```

#### Parameter Inject

```java
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sender {
}

@Component
public class SenderMethodParameterProvider implements HandlerMethodParameterProvider {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(Sender.class) != null && parameter.getParameterType().equals(Player.class);
    }

    @Override
    public Object resolveParameter(CommandArgs commandArgs, MethodParameter parameter) {
        Player player = (Player) commandArgs.getCommandSender();
        return player;
    }
}

@CommandService("message")
public class Send {
    @Command("help")
    public void sendMessage(@Sender Player player) {
        player.sendMessage("[Server] -----------------------");
        player.sendMessage("[Server] /message <message>");
        player.sendMessage("[Server] /message <playerName> <message>");
        player.sendMessage("[Server] -----------------------");
    }

    @Command("<message>")
    public void broadcastMessage(@PathVariable String message) {
        Bukkit.broadcastMessage(message);
    }

    @Command("<playerName> <message>")
    public void messageToPlayer(@PathVariable String playerName, @PathVariable String message) {
        Player player = Bukkit.getPlayer(playerName);
        player.sendMessage(message);
    }
}
```

#### 기본 제공 파라미터
- CommandArgs
- @PathVariable
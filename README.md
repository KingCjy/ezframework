# Ezframework
[![Download](https://api.bintray.com/packages/kingcjy/ezframework/ezframework-core/images/download.svg) ](https://bintray.com/kingcjy/ezframework/ezframework-core/_latestVersion)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kingcjy/ezframework-core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.kingcjy%22%20AND%20a:%22ezframework-core%22)
[![Build Status](https://travis-ci.org/KingCjy/ezframework.svg?branch=master)](https://travis-ci.org/KingCjy/ezframework)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


Ezframework는 Bukkit에서 사용할 수 있는 IOC 기반 커맨드 프레임워크입니다.


## 사용 방법

### Maven

```xml
<dependencies>
    <dependency>
      <groupId>io.github.kingcjy</groupId>
      <artifactId>ezframework-core</artifactId>
      <version>1.1.1</version>
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

### Gradle
```groovy
dependencies {
    implementation 'io.github.kingcjy:ezframework-core:1.1.1'
}

compileJava.options.compilerArgs = ['-parameters']
```

### 초기화

```java
class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        EzFramework.run(this);
    }
}
```

### 커맨드 추가
```java

@EzCommand("message")
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
        
        if(player != null) {
            player.sendMessage(message);
        }
    }
}
```

### 명령어 오류
command: `/message`
```java
@EzCommand("message")
public class Send {
    @NotFound
    public void notFound(@Sender Player player) {
        player.sendMessage("[Server] -----------------------");
        player.sendMessage("[Server] /message <message>");
        player.sendMessage("[Server] /message <playerName> <message>");
        player.sendMessage("[Server] -----------------------");
    }
    ...
}
```

### 파라미터 추가
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

@EzCommand("message")
public class Send {
    @Command("help")
    public void sendMessage(@Sender Player player) {
        player.sendMessage("[Server] -----------------------");
        player.sendMessage("[Server] /message <message>");
        player.sendMessage("[Server] /message <playerName> <message>");
        player.sendMessage("[Server] -----------------------");
    }
    ...
}
```
### 기본 제공 파라미터

```java
@Command("<placeholder>")
public void onCommand(CommandArgs commandArgs, CommandSender commandSender, Command command, @PathVariable String placeholder) {
        
}
```

#### @PathVariable

```java
@Command("message send <playerName> <message>")
public void sendMessage(@PathVariable String playerName, @PathVariable String message)
```
`@PathVariable` 은 공백 단위로 파라미터가 주입됩니다.
예시) `/message send KingCjy hi` -> `playerName: KingCjy`, `message: hi`

하지만 마지막 `placeholder`인 `message` 는 공백을 무시합니다.
예시) `/message send KingCjy hi my name is KingCjy` ->` playerName: KingCjy`, `message: hi my name is KingCjy`


### 이벤트 등록

`@EzEvent` 어노테이션을 붙이면 자동으로 이벤트에 등록됩니다.

`getServer().getPluginManager().registerEvents(Listener listener, JavaPlugin javaplugin);`를 대신 합니다.

```java
@EzEvent
public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("[TestPlugin]: 환영합니다!");
    }
}
```

### Help 명령어 자동생성
`@GenerateHelpCommand`, `@Description`
```java
@GenerateHelpCommand
@EzCommand("message")
public class MessageCommand {
    @Command("send <playerName> <message>")
    @Description("플레이어에게 메세지를 보냅니다.")
    public void messageToPlayer(@PathVariable String playerName, @PathVariable String message) {
        Player player = Bukkit.getPlayer(playerName);

        if(player != null) {
            player.sendMessage(message);
        }
    }

    @Command("broadcast <message>")
    @Description("플레이어 전체에게 메세지를 보냅니다.")
    public void broadcastMessage(@PathVariable String message) {
        Bukkit.broadcastMessage(message);
    }
}
```

#### 기본 메세지
`/message help`
```
-------- [EzFramework] --------
/message send <playerName> <message> - 플레이어에게 메세지를 보냅니다.
/message broadcast <message> - 플레이어 전체에게 메세지를 보냅니다.
-------------------------------
```

#### 메세지 커스텀
`resource/me/kingcjy/ezframework/resource/help.ez` 추가

`default`
```
<prefix>-------- [EzFramework] --------</prefix>
<command>§3{help.command} - {help.description}</command>
<suffix>-------------------------------</suffix>
```
`커스텀`
```
<prefix>
-------------------------------
-------- [내 플러그인!!] ---------
</prefix>
<command>§3{help.command} - {help.description}</command>
<suffix>
-------------------------------
</suffix>
```
`결과`
```
-------------------------------
-------- [내 플러그인!!] ---------
/message send <playerName> <message> - 플레이어에게 메세지를 보냅니다.
/message broadcast <message> - 플레이어 전체에게 메세지를 보냅니다.
-------------------------------
```


### 사용 예제

예제 >> [GITHUB](https://github.com/KingCjy/ezframework-sample "github link")
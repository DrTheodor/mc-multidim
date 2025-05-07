# MultiDim Mod
A FabricMC library mod, that allows you to dynamically create, load, unload and delete worlds.

## Example Usage

### Getting started

Add the jitpack maven repository:
```groovy
maven {
    url "https://theo.is-a.dev/maven-repo/"
}
```

Add the dependency:
```groovy
include(modImplementation("com.github.DrTheodor:mc-multidim:v2.0.0"))
```

```java
static WorldBluePrint MY_WORLD_BLUEPRINT;

ServerLifecycleEvents.SERVER_STARTING.register(server -> {
    MY_WORLD_BLUEPRINT = new WorldBlueprint(new Identifier("modid", "myworld"))
            .setPersistent(true).shouldTickTime(false)
            .withCreator(MyServerWorldClass::new) // or just MultiDimServerWorld
            .withType(new Identifier("modid", "myworld_dimension_type"))
            .withGenerator(new VoidChunkGenerator(
                    server.getRegistryManager().get(RegistryKeys.BIOME),
                    RegistryKey.of(RegistryKeys.BIOME, AITMod.id("plains"))
            ));

    MultiDim.get(server).register(MY_WORLD_BLUEPRINT);
});
```

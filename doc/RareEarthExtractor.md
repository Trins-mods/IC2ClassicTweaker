## Rare Earth Extractor

### Class

```java
import mods.ic2.RareEarthExtractor;
```

### Method

#### `addRareEarthEntries`

```java
/*
 * Arguments: value, inputs
 *   - float value
 *   - IItemStack... inputs      Can have more then one specified for the input. If so all the specified items give the same spcified value.
 */
RareEarthExtractor.addRareEarthEntries(1.0F, <minecraft:bedrock>, <minecraft:iron_block>);
```

//TODO: Get this to actually work.
#### `removeRareEarthEntries`

```java
/*
 * Arguments: inputs            Currently this doesn't actually work.
 *   - IItemStack... inputs     Removes all the specified items from the list of items giving rare earth values.
 */
RareEarthExtractor.removeRareEarthEntries(<minecraft:iron_block>);
```
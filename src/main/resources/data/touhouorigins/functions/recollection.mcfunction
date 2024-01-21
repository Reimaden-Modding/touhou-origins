# Add a tag to exclude user from this function
tag @s add satoriSelf

# Play a sound around the target to nearby players
execute at @e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf] run playsound touhouorigins:origin.satori.recollect player @a[distance=..32] ~ ~ ~ 2 2

# Proceed depending on if the target is the Satori (Closed Eye) Origin or not
execute unless entity @e[type=minecraft:player,limit=1,sort=nearest,predicate=touhouorigins:is_closed_eye] run tellraw @s ["",{"translate":"power.touhouorigins.recollection.player","with":[{"selector":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]","color":"#D02020"}]},"\n",{"translate":"layer.origins.origin.name","color":"#C02038"},{"text":": ","color":"#C02038"},{"nbt":"cardinal_components.origins:origin.OriginLayers","entity":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]"},"\n",{"translate":"power.touhouorigins.recollection.spawnXYZ","color":"#B0204F"},{"text":": ","color":"#B0204F"},{"nbt":"SpawnX","entity":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]"},{"text":" / "},{"nbt":"SpawnY","entity":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]"},{"text":" / "},{"nbt":"SpawnZ","entity":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]"},"\n",{"translate":"power.touhouorigins.recollection.spawnDimension","color":"#A02067"},{"text":": ","color":"#A02067"},{"nbt":"SpawnDimension","entity":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]"},"\n",{"translate":"power.touhouorigins.recollection.lastDeathLocation","color":"#90207F"},{"text":": ","color":"#90207F"},{"nbt":"LastDeathLocation","entity":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]"}]
execute if entity @e[type=minecraft:player,limit=1,sort=nearest,predicate=touhouorigins:is_closed_eye] run tellraw @s {"translate":"power.touhouorigins.recollection.fail","with":[{"selector":"@e[type=minecraft:player,limit=1,sort=nearest,tag=!satoriSelf]","color":"#A0DA81"}]}

# Remove tag as it's no longer needed
tag @s remove satoriSelf
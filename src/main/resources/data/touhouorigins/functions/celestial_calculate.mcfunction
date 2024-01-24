# Calculates the damage bonus of Heavenly Descendant based on the player's Y position

# Repeat the same calculations from celestial_scores.mcfunction
execute store result score @s celestialY run data get entity @s Pos[1]
scoreboard players set @s celestialConstant 86

# Calculate the damage

# Reduce the Y position by the constant
scoreboard players operation @s celestialY -= @s celestialConstant
# Add the remaining difference to Heavenly Descendant's resource
resource operation @s touhouorigins:celestial/heavenly_descendant_resource = @s celestialY
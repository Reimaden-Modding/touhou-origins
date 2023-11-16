# Calculates the amount of damage that Searing Rage should do based on the player's current health

# Repeat the same calculations from vengeful_spirit_scores.mcfunction
execute store result score @s vsMaxHealth run attribute @s generic.max_health get
scoreboard players set @s vsConstant 6
execute store result score @s vsCurrentHealth run data get entity @s Health

# Calculate the damage

# Remove the player's current health from their max health to get the difference
scoreboard players operation @s vsMaxHealth -= @s vsCurrentHealth
# Reduce the difference by the constant
scoreboard players operation @s vsMaxHealth -= @s vsConstant
# Add the remaining difference to Searing Rage's resource
# This resource is added to the player's melee damage attribute modifier
resource operation @s touhouorigins:vengeful_spirit/searing_rage_resource = @s vsMaxHealth
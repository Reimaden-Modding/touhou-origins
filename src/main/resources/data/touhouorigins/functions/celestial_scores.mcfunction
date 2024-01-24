# Sets up the scoreboard objectives when the power is added to the player
scoreboard objectives add celestialY dummy
scoreboard objectives add celestialConstant dummy

# Do the initial calculations
# These are repeated in celestial_calculate.mcfunction

# Get the player's Y position and store it in the celestialY objective
execute store result score @s celestialY run data get entity @s Pos[1]
# The constant is used to reduce the Y value so players won't gain a bonus close to the sea level
scoreboard players set @s celestialConstant 86
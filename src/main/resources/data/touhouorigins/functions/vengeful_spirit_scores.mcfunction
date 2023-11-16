# Sets up the scoreboard objectives when the power is added to the player
scoreboard objectives add vsMaxHealth dummy
scoreboard objectives add vsCurrentHealth dummy
scoreboard objectives add vsConstant dummy

# Do the initial calculations
# These are repeated in vengeful_spirit_calculate.mcfunction

# Get the player's max health and store it in the vsMaxHealth objective
execute store result score @s vsMaxHealth run attribute @s generic.max_health get
# The constant is used to reduce the damage bonus so that players have to lose some health before they start receiving the bonus
scoreboard players set @s vsConstant 6
# Get the player's current health and store it in the vsCurrentHealth objective
execute store result score @s vsCurrentHealth run data get entity @s Health
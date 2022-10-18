scoreboard players set @s vsMaxHealth 20
scoreboard players set @s vsConstant 6
execute store result score @s vsCurrentHealth run data get entity @s Health
scoreboard players operation @s vsMaxHealth -= @s vsCurrentHealth
scoreboard players operation @s vsMaxHealth -= @s vsConstant
resource operation @s touhouorigins:searing_rage_resource = @s vsMaxHealth
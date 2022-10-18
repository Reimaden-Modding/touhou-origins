scoreboard objectives add vsMaxHealth dummy
scoreboard objectives add vsCurrentHealth dummy
scoreboard objectives add vsConstant dummy
scoreboard players set @s vsMaxHealth 20
scoreboard players set @s vsConstant 6
execute store result score @s vsCurrentHealth run data get entity @s Health
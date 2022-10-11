# @s - Horse entity
# @a[tag = playerPassenger, limit = 1] - The player currently riding the horse entity

# Set the horse entity's `Tame` NBT to `1b` (true)
data modify entity @s Tame set value 1b

# Set the horse entity's `Owner` NBT as the player that's currently riding the horse entity's `UUID`, making the player that's currently riding the horse entity the owner of the horse
data modify entity @s Owner set from entity @a[tag = playerPassenger, limit = 1] UUID
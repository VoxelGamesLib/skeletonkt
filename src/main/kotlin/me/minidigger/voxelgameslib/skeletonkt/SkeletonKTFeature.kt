package me.minidigger.voxelgameslib.skeletonkt

import com.voxelgameslib.kvgl.*
import com.voxelgameslib.voxelgameslib.event.GameEvent
import com.voxelgameslib.voxelgameslib.feature.AbstractFeature
import com.voxelgameslib.voxelgameslib.feature.FeatureInfo
import com.voxelgameslib.voxelgameslib.feature.features.TeamFeature
import org.bukkit.event.entity.PlayerDeathEvent

@FeatureInfo(name = "SkeletonKTFeature", author = "MiniDigger", version = "1.0.0", description = "SkeletonKTFeature description")
class SkeletonKTFeature : AbstractFeature() {

    private val log by logByClass<SkeletonKTFeature>()


    override fun start() {

        val teamFeature = phase.getFeature<TeamFeature>()

        phase.game.players.forEach { user ->
            teamFeature.getTeam(user).ifPresent { log.finer("${user.rawDisplayName} is on team ${it.name}") }
        }

    }

    override fun getDependencies() = depend(TeamFeature::class)


    @GameEvent
    fun PlayerDeathEvent.onDeath() {
        // stuff here I guess
    }

}
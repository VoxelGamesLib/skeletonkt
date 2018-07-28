package me.minidigger.voxelgameslib.skeletonkt

import com.voxelgameslib.voxelgameslib.feature.features.TeamSelectFeature
import com.voxelgameslib.voxelgameslib.game.AbstractGame
import com.voxelgameslib.voxelgameslib.game.GameDefinition
import com.voxelgameslib.voxelgameslib.game.GameInfo
import com.voxelgameslib.voxelgameslib.phase.phases.GracePhase
import com.voxelgameslib.voxelgameslib.phase.phases.LobbyWithVotePhase

@GameInfo(name = "SkeletonKTGame", author = "MiniDigger", version = "v1.0", description = "SkeletonKTGame description")
class SkeletonKTGame : AbstractGame(SkeletonKTPlugin.GAMEMODE) {

    override fun initGameFromModule() {
        minAndMaxPlayers = 2

        val votePhase = createPhase<LobbyWithVotePhase> {
            it.addFeature(createFeature<TeamSelectFeature>(it))
        }

        buildPhases(votePhase) {
            +createPhase<GracePhase>()
            +createPhase<SkeletonKTPhase>()
        }

        buildPhases {
            +createPhase<LobbyWithVotePhase> {
                it.addFeature(createFeature<TeamSelectFeature>(it))
            }
            +createPhase<GracePhase>()
            +createPhase<SkeletonKTPhase>()
        }


        loadMap()
    }

    override fun initGameFromDefinition(gameDefinition: GameDefinition) {
        super.initGameFromDefinition(gameDefinition)

        loadMap()
    }

}
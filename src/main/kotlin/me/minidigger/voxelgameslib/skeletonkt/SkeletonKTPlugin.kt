package me.minidigger.voxelgameslib.skeletonkt

import com.voxelgameslib.voxelgameslib.module.ModuleInfo
import com.voxelgameslib.voxelgameslib.plugin.VGLPlugin

@ModuleInfo(name = "SkeletonKT", authors = ["MiniDigger"], version = "1.0.0")
class SkeletonKTPlugin : VGLPlugin() {

    override fun getGameMode() = GAMEMODE


    companion object {

        val GAMEMODE = newGameMode<SkeletonKTGame>("SkeletonKT")

    }

}
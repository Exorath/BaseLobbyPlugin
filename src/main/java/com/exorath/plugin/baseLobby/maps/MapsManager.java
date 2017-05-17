/*
 * Copyright 2017 Exorath
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.exorath.plugin.baseLobby.maps;

import com.exorath.plugin.baseLobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by toonsev on 5/17/2017.
 */
public class MapsManager implements Listener{
    private ExoWorld lobbyMap;

    public MapsManager() {
        List<ExoWorld> exoWorlds = getExoMapNames().stream()
                .collect(Collectors.toList());
        if (exoWorlds.size() == 0)
            Main.terminate("No maps found, add a map with an exomap.yml");

        this.lobbyMap = exoWorlds.get(new Random().nextInt(exoWorlds.size()));
        if (lobbyMap.getConfiguration() == null)
            Main.terminate("The map " + lobbyMap.getMapName() + " is not configured. Please add an exomap.yml Shutting down!");
        lobbyMap.getWorld().setSpawnLocation( lobbyMap.getSpawn().getBlockX(), lobbyMap.getSpawn().getBlockY(), lobbyMap.getSpawn().getBlockZ());
    }

    private List<ExoWorld> getExoMapNames() {
        File mapContainer = Bukkit.getWorldContainer();
        List<ExoWorld> exoWorlds = new ArrayList<>();
        for (File mapDir : mapContainer.listFiles((dir, name) -> new File(dir, name).isDirectory())) {
            File exoDat = new File(mapDir, "exomap.yml");
            if (!exoDat.isFile())
                continue;
            exoWorlds.add(new ExoWorld(mapDir.getName()));
        }
        return exoWorlds;
    }

    public ExoWorld getLobbyMap() {
        return lobbyMap;
    }

    @EventHandler
    public void onPlayerSpawnLocationReq(PlayerSpawnLocationEvent event){
        event.setSpawnLocation(getLobbyMap().getSpawn());
    }
}

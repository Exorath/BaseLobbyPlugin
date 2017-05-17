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

package com.exorath.plugin.baseLobby.connector;

import com.exorath.plugin.base.ExoBaseAPI;
import com.exorath.plugin.baseLobby.Main;
import com.exorath.service.connector.res.BasicServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.net.UnknownHostException;

/**
 * Created by toonsev on 5/17/2017.
 */
public class BaseAPIManager implements Listener{
    private String gameId;
    private ExoBaseAPI exoBaseAPI;

    public BaseAPIManager(String gameId, ExoBaseAPI exoBaseAPI) {
        this.gameId = gameId;
        this.exoBaseAPI = exoBaseAPI;
        if(gameId == null)
            Main.terminate("No 'gameId' provided in config");
        try {
            exoBaseAPI.setupGame(new BasicServer(getGameId(), "default", "lobby"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Main.terminate();
        }
    }

    private String getGameId(){
        return gameId;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        exoBaseAPI.onGameJoin(event.getPlayer());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        exoBaseAPI.onGameLeave(event.getPlayer());
    }
}

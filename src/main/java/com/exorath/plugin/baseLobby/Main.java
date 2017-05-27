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

package com.exorath.plugin.baseLobby;

import com.exorath.exoProtection.ProtectionListener;
import com.exorath.plugin.base.ExoBaseAPI;
import com.exorath.plugin.baseLobby.connector.BaseAPIManager;
import com.exorath.plugin.baseLobby.hud.HudManager;
import com.exorath.plugin.baseLobby.maps.MapsManager;
import com.exorath.plugin.baseLobby.protection.LobbyProtectionConfiguration;
import com.exorath.service.mysteryKey.api.MysteryKeyServiceAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by toonsev on 5/17/2017.
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MapsManager(), this);
        Bukkit.getPluginManager().registerEvents(new BaseAPIManager(getConfig().getString("gameId"), ExoBaseAPI.getInstance()), this);
        Bukkit.getPluginManager().registerEvents(new HudManager(new MysteryKeyServiceAPI(getMysteryKeyServiceAddress())), this);
        Bukkit.getPluginManager().registerEvents(new ProtectionListener(new LobbyProtectionConfiguration()), this);
    }

    private String getMysteryKeyServiceAddress(){
        String address = System.getenv("MYSTERYKEY_SERVICE_ADDRESS");
        if(address == null || address.equals(""))
            Main.terminate("MYSTERYKEY_SERVICE_ADDRESS env not provided.");
        return address;
    }

    public static void terminate() {
        System.out.println("1v1Plugin is terminating...");
        Bukkit.shutdown();
        System.out.println("Termination failed, force exiting system...");
        System.exit(1);
    }

    public static void terminate(String message) {
        System.out.println(message);
        System.out.println("1v1Plugin is terminating...");
        Bukkit.shutdown();
        System.out.println("Termination failed, force exiting system...");
        System.exit(1);
    }
}

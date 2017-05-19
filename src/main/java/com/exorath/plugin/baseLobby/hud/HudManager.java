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

package com.exorath.plugin.baseLobby.hud;

import com.exorath.exoHUD.DisplayPackage;
import com.exorath.exoHUD.DisplayProperties;
import com.exorath.exoHUD.HUDPackage;
import com.exorath.exoHUD.plugin.HudAPI;
import com.exorath.exoHUD.removers.NeverRemover;
import com.exorath.exoHUD.texts.PlainText;
import com.exorath.plugin.baseLobby.hud.hudPackages.FragmentsAndKeysText;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

/**
 * Created by toonsev on 5/19/2017.
 */
public class HudManager  implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        HUDPackage fragmentsAndKeysPackage = HUDPackage.create(
                Arrays.asList(PlainText.plain(" "), new FragmentsAndKeysText(event.getPlayer())));
        HudAPI.getInstance().getHudPlayer(event.getPlayer()).getScoreboardLocation()
                .addDisplayPackage(new DisplayPackage(fragmentsAndKeysPackage, DisplayProperties.create(0, NeverRemover.never())));
    }
}

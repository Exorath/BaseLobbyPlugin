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

package com.exorath.plugin.baseLobby.hud.hudPackages;

import com.exorath.exoHUD.HUDText;
import com.exorath.exoHUD.texts.IterateText;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

/**
 * Created by toonsev on 5/19/2017.
 */
public class FragmentsAndKeysText extends IterateText {
    public FragmentsAndKeysText(Player player) {
        super(10, TimeUnit.SECONDS, Schedulers.computation(), getFragmentAndKeysTexts(player));
    }

    private static HUDText[] getFragmentAndKeysTexts(Player player){
        return new HUDText[]{new FragmentsText(player), new KeysText(player)};
    }
}

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
import com.exorath.service.mysteryKey.api.MysteryKeyServiceAPI;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by toonsev on 5/19/2017.
 */
public class KeysText implements HUDText {
    private static final TextComponent KEYS_PREFIX = new TextComponent("Keys: ");

    static {
        KeysText.KEYS_PREFIX.setColor(ChatColor.WHITE);
    }

    private Scheduler scheduler = Schedulers.io();

    private MysteryKeyServiceAPI mysteryKeyServiceAPI;
    private Player player;

    public KeysText(MysteryKeyServiceAPI mysteryKeyServiceAPI, Player player) {
        this.mysteryKeyServiceAPI = mysteryKeyServiceAPI;
        this.player = player;
    }

    @Override
    public Observable<List<TextComponent>> getTextObservable() {
        return Observable.<List<TextComponent>>create(s -> {
            TextComponent amountComponent = new TextComponent(getSuffix(getKeys()));
            amountComponent.setColor(ChatColor.GOLD);
            s.onNext(Arrays.asList(KEYS_PREFIX, amountComponent));
        }).subscribeOn(Schedulers.io());
    }

    private String getSuffix(int fragments) {
        return fragments + "";
    }

    private int getKeys() {
        return mysteryKeyServiceAPI.getPlayer(player.getUniqueId().toString()).getKeys();
    }
}

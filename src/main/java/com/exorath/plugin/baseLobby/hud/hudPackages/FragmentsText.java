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

/**
 * Created by toonsev on 5/19/2017.
 */
public class FragmentsText implements HUDText {
    private static final TextComponent FRAGMENT_PREFIX = new TextComponent("Key Fragments: ");
    static {
        FragmentsText.FRAGMENT_PREFIX.setColor(ChatColor.WHITE);
    }

    private Scheduler scheduler = Schedulers.io();

    private MysteryKeyServiceAPI mysteryKeyServiceAPI;
    private Player player;

    public FragmentsText(MysteryKeyServiceAPI mysteryKeyServiceAPI, Player player) {
        this.mysteryKeyServiceAPI = mysteryKeyServiceAPI;
        this.player = player;
    }

    @Override
    public Observable<List<TextComponent>> getTextObservable() {
        return Observable.<List<TextComponent>>create(s -> {
            TextComponent goodText = new TextComponent(getGoodString(getFragments()));
            goodText.setColor(ChatColor.GOLD);
            TextComponent badText = new TextComponent(getBadString(getFragments()));
            badText.setColor(ChatColor.GRAY);
            s.onNext(Arrays.asList(FRAGMENT_PREFIX, goodText, badText));
        }).subscribeOn(Schedulers.io());
    }

    private String getGoodString(int fragments) {
        String suffix;
        switch (fragments) {
            case 0:
                suffix = "";
                break;
            case 1:
                suffix = "⦿";
                break;
            case 2:
                suffix = "⦿⦿";
                break;
            case 3:
                suffix = "⦿⦿⦿";
                break;
            default:
                suffix = fragments + "";
        }
        return suffix;
    }
    private String getBadString(int fragments) {
        String suffix;
        switch (fragments) {
            case 0:
                suffix = "⦾⦾⦾";
                break;
            case 1:
                suffix = "⦾⦾";
                break;
            case 2:
                suffix = "⦾";
                break;
            case 3:
                suffix = "";
                break;
            default:
                suffix = " / 3";
        }
        return suffix;
    }
    private int getFragments() {
        return mysteryKeyServiceAPI.getPlayer(player.getUniqueId().toString()).getFragments();
    }
}

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
public class FragmentsText implements HUDText {
    private static final TextComponent FRAGMENT_PREFIX = new TextComponent("Key Fragments: ");
    static {
        FragmentsText.FRAGMENT_PREFIX.setColor(ChatColor.WHITE);
    }
    private static final long interval = 30;
    private static final TimeUnit intervalUnit = TimeUnit.SECONDS;

    private Scheduler scheduler = Schedulers.io();

    private Player player;

    public FragmentsText(Player player) {
        this.player = player;
    }

    @Override
    public Observable<List<TextComponent>> getTextObservable() {
        return Observable.create(s -> {
            TextComponent amountComponent = new TextComponent(getSuffix(getFragments()));
            amountComponent.setColor(ChatColor.GOLD);
            s.onNext(Arrays.asList(FRAGMENT_PREFIX, amountComponent));
        });
    }

    private String getSuffix(int fragments) {
        String suffix;
        switch (fragments) {
            case 0:
                suffix = "⦾⦾⦾";
                break;
            case 1:
                suffix = "⦿⦾⦾";
                break;
            case 2:
                suffix = "⦿⦿⦾";
                break;
            case 3:
                suffix = "⦿⦿⦿";
                break;
            default:
                suffix = fragments +  " / 3";
        }
        return suffix;
    }

    private int getFragments() {
        return 0;
    }
}

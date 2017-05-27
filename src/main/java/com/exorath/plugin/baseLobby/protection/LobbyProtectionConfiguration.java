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

package com.exorath.plugin.baseLobby.protection;

import com.exorath.exoProtection.config.ProtectionConfiguration;
import org.bukkit.GameMode;

/**
 * Created by toonsev on 5/27/2017.
 */
public class LobbyProtectionConfiguration implements ProtectionConfiguration {
    @Override
    public boolean canBlockBurn() {
        return false;
    }

    @Override
    public boolean canBlockDispenseItems() {
        return false;
    }

    @Override
    public boolean canBlockFade() {
        return false;
    }

    @Override
    public boolean canBlockForm() {
        return false;
    }

    @Override
    public boolean canBlockFlow() {
        return false;
    }

    @Override
    public boolean canBlockGrow() {
        return false;
    }

    @Override
    public boolean canBlockIgnite() {
        return false;
    }

    @Override
    public boolean canPistonWork() {
        return false;
    }

    @Override
    public boolean canBlockSpread() {
        return false;
    }

    @Override
    public boolean canLeavesDecay() {
        return false;
    }

    @Override
    public boolean canPlayersChangeSign() {
        return false;
    }

    @Override
    public boolean canStructuresGrow() {
        return false;
    }

    @Override
    public boolean canSpawnEntities() {
        return false;
    }

    @Override
    public GameMode getDefaultGamemode() {
        return GameMode.ADVENTURE;
    }

    @Override
    public boolean canBreakBlocks() {
        return false;
    }

    @Override
    public boolean canPlaceBlocks() {
        return false;
    }

    @Override
    public boolean canInteract() {
        return false;
    }

    @Override
    public boolean canDamageItems() {
        return false;
    }

    @Override
    public boolean canPickupItems() {
        return false;
    }

    @Override
    public boolean canPickupArrows() {
        return false;
    }

    @Override
    public boolean canUsePortal() {
        return false;
    }

    @Override
    public boolean canShear() {
        return false;
    }

    @Override
    public boolean canSwapHandItems() {
        return false;
    }

    @Override
    public boolean canUnleashEntity() {
        return false;
    }

    @Override
    public boolean canDamageBlock() {
        return false;
    }

    @Override
    public boolean canInteractInventory() {
        return false;
    }

    @Override
    public Boolean isAlwaysRaining() {
        return false;
    }

    @Override
    public boolean doNightCycle() {
        return false;
    }

    @Override
    public long getInitialTime() {
        return 12000;
    }
}

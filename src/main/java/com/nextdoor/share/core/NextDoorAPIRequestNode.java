package com.nextdoor.share.core;

import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.share.interfaces.NextDoorAPIResponse;
import com.nextdoor.util.NextDoorUtil;

public abstract class NextDoorAPIRequestNode implements NextDoorAPIResponse {
    protected NextDoorAPIAuth nextDoorAPIAuth;

    public NextDoorAPIRequestNode() {
        this.nextDoorAPIAuth = NextDoorAPIAuth.defaultNextDoorAPIAuth();
    }

    public NextDoorAPIRequestNode(NextDoorAPIAuth nextDoorAPIAuth) {
        NextDoorUtil.ensureObjectNotNull(nextDoorAPIAuth, "nextDoorAPIAuth");
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public NextDoorAPIAuth getNextDoorAPIAuth() {
        return nextDoorAPIAuth;
    }

    public void setNextDoorAPIAuth(NextDoorAPIAuth nextDoorAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }
}

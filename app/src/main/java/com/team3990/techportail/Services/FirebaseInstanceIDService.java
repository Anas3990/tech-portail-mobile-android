package com.team3990.techportail.Services;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by Anas Merbouh on 17-12-31.
 */

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    //
    private static final String TEAM_MEMBERS_TOPIC = "team_members";

    //
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //
        FirebaseMessaging.getInstance().subscribeToTopic(TEAM_MEMBERS_TOPIC);
    }
}

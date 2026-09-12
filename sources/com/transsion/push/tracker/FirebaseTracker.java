package com.transsion.push.tracker;

import android.os.Bundle;
import com.transsion.push.tracker.Tracker;

/* loaded from: classes.dex */
public class FirebaseTracker {

    /* renamed from: a, reason: collision with root package name */
    private static FirebaseTracker f50959a;

    /* renamed from: b, reason: collision with root package name */
    private static ITracker f50960b;

    private FirebaseTracker() {
    }

    public static FirebaseTracker getInstance() {
        if (f50959a == null) {
            f50959a = new FirebaseTracker();
        }
        return f50959a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Tracker.KEY key, Bundle bundle) {
        ITracker iTracker;
        if (bundle == null || (iTracker = f50960b) == null) {
            return;
        }
        iTracker.track(key, bundle);
    }

    public void setListener(ITracker iTracker) {
        f50960b = iTracker;
    }
}

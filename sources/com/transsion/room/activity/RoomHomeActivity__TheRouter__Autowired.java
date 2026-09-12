package com.transsion.room.activity;

import androidx.annotation.Keep;
import bg.a;
import com.therouter.TheRouter;
import com.therouter.router.b;
import java.util.Iterator;

@Keep
/* loaded from: classes6.dex */
public class RoomHomeActivity__TheRouter__Autowired {
    public static final String TAG = "Created by kymjs, and APT Version is 1.3.0.";
    public static final String THEROUTER_APT_VERSION = "1.3.0";

    public static void autowiredInject(Object obj) {
        if (obj instanceof RoomHomeActivity) {
            RoomHomeActivity roomHomeActivity = (RoomHomeActivity) obj;
            Iterator it = TheRouter.g().iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    String str = (String) aVar.a("java.lang.String", roomHomeActivity, new b("java.lang.String", "ops", 0, "", "com.transsion.room.activity.RoomHomeActivity", "insertPostOps", false, "No desc."));
                    if (str != null) {
                        roomHomeActivity.insertPostOps = str;
                    }
                } catch (Exception e11) {
                    if (TheRouter.m()) {
                        e11.printStackTrace();
                    }
                }
                try {
                    String str2 = (String) aVar.a("java.lang.String", roomHomeActivity, new b("java.lang.String", "post_id", 0, "", "com.transsion.room.activity.RoomHomeActivity", "insertPostId", false, "No desc."));
                    if (str2 != null) {
                        roomHomeActivity.insertPostId = str2;
                    }
                } catch (Exception e12) {
                    if (TheRouter.m()) {
                        e12.printStackTrace();
                    }
                }
            }
        }
    }
}

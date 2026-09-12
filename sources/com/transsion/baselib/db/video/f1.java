package com.transsion.baselib.db.video;

import androidx.room.RoomDatabase;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class f1 implements e1 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43209a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43210b = new a();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `video_land_ad` (`resourceId`,`startAdDayKey`,`endAdDayKey`) VALUES (?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, VideoLandAdBean videoLandAdBean) {
            if (videoLandAdBean.getResourceId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, videoLandAdBean.getResourceId());
            }
            eVar.c(2, videoLandAdBean.getStartAdDayKey());
            eVar.c(3, videoLandAdBean.getEndAdDayKey());
        }
    }

    public f1(RoomDatabase roomDatabase) {
        this.f43209a = roomDatabase;
    }

    public static List a() {
        return Collections.emptyList();
    }
}

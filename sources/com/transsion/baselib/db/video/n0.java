package com.transsion.baselib.db.video;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.config.utils.CommonUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class n0 implements UGCVideoDetailPlayDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43247a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43248b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f43249c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f43250d = new c();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `ugc_video_detail_play` (`collectionId`,`ugcVideoId`,`progress`,`title`,`coverUrl`,`thumbnail`,`position`,`type`,`cateLev1Id`,`cateLev2Id`,`cateLev3Id`,`cateLev4Id`,`timeStamp`,`subtitleSelectId`,`totalDuration`,`subjectDurationSeconds`,`averageHueLight`,`subjectType`,`hasDelete`,`playMode`,`downloadUrl`,`downloadResid`,`downloadFilePath`,`downloadSize`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`rewardPlayed`,`rewardUnlock`,`rewardFree`,`ops`,`uid`,`userName`,`userAvatar`,`description`,`videoStyle`,`kidId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, UGCVideoDetailPlayBean uGCVideoDetailPlayBean) {
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, uGCVideoDetailPlayBean.getCollectionId());
            }
            if (uGCVideoDetailPlayBean.getUgcVideoId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, uGCVideoDetailPlayBean.getUgcVideoId());
            }
            eVar.c(3, uGCVideoDetailPlayBean.getProgress());
            if (uGCVideoDetailPlayBean.getTitle() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, uGCVideoDetailPlayBean.getTitle());
            }
            if (uGCVideoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, uGCVideoDetailPlayBean.getCoverUrl());
            }
            if (uGCVideoDetailPlayBean.getThumbnail() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, uGCVideoDetailPlayBean.getThumbnail());
            }
            eVar.c(7, uGCVideoDetailPlayBean.getPosition());
            if (uGCVideoDetailPlayBean.getType() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, uGCVideoDetailPlayBean.getType());
            }
            if (uGCVideoDetailPlayBean.getCateLev1Id() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, uGCVideoDetailPlayBean.getCateLev1Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev2Id() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, uGCVideoDetailPlayBean.getCateLev2Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev3Id() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, uGCVideoDetailPlayBean.getCateLev3Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev4Id() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, uGCVideoDetailPlayBean.getCateLev4Id().intValue());
            }
            eVar.c(13, uGCVideoDetailPlayBean.getTimeStamp());
            if (uGCVideoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, uGCVideoDetailPlayBean.getSubtitleSelectId());
            }
            if (uGCVideoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, uGCVideoDetailPlayBean.getTotalDuration().longValue());
            }
            if (uGCVideoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(16);
            } else {
                eVar.c(16, uGCVideoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (uGCVideoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(17);
            } else {
                eVar.j(17, uGCVideoDetailPlayBean.getAverageHueLight());
            }
            if (uGCVideoDetailPlayBean.getSubjectType() == null) {
                eVar.g(18);
            } else {
                eVar.c(18, uGCVideoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(19, uGCVideoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getPlayMode() == null) {
                eVar.g(20);
            } else {
                eVar.j(20, uGCVideoDetailPlayBean.getPlayMode());
            }
            if (uGCVideoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(21);
            } else {
                eVar.j(21, uGCVideoDetailPlayBean.getDownloadUrl());
            }
            if (uGCVideoDetailPlayBean.getDownloadResid() == null) {
                eVar.g(22);
            } else {
                eVar.j(22, uGCVideoDetailPlayBean.getDownloadResid());
            }
            if (uGCVideoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(23);
            } else {
                eVar.j(23, uGCVideoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(24, uGCVideoDetailPlayBean.getDownloadSize());
            if (uGCVideoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(25);
            } else {
                eVar.c(25, uGCVideoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (uGCVideoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(26);
            } else {
                eVar.c(26, uGCVideoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(27, uGCVideoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(28, uGCVideoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(29, uGCVideoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getOps() == null) {
                eVar.g(30);
            } else {
                eVar.j(30, uGCVideoDetailPlayBean.getOps());
            }
            if (uGCVideoDetailPlayBean.getUid() == null) {
                eVar.g(31);
            } else {
                eVar.j(31, uGCVideoDetailPlayBean.getUid());
            }
            if (uGCVideoDetailPlayBean.getUserName() == null) {
                eVar.g(32);
            } else {
                eVar.j(32, uGCVideoDetailPlayBean.getUserName());
            }
            if (uGCVideoDetailPlayBean.getUserAvatar() == null) {
                eVar.g(33);
            } else {
                eVar.j(33, uGCVideoDetailPlayBean.getUserAvatar());
            }
            if (uGCVideoDetailPlayBean.getDescription() == null) {
                eVar.g(34);
            } else {
                eVar.j(34, uGCVideoDetailPlayBean.getDescription());
            }
            if (uGCVideoDetailPlayBean.getVideoStyle() == null) {
                eVar.g(35);
            } else {
                eVar.j(35, uGCVideoDetailPlayBean.getVideoStyle());
            }
            if (uGCVideoDetailPlayBean.getKidId() == null) {
                eVar.g(36);
            } else {
                eVar.j(36, uGCVideoDetailPlayBean.getKidId());
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `ugc_video_detail_play` WHERE `collectionId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, UGCVideoDetailPlayBean uGCVideoDetailPlayBean) {
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, uGCVideoDetailPlayBean.getCollectionId());
            }
        }
    }

    /* loaded from: classes5.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `ugc_video_detail_play` SET `collectionId` = ?,`ugcVideoId` = ?,`progress` = ?,`title` = ?,`coverUrl` = ?,`thumbnail` = ?,`position` = ?,`type` = ?,`cateLev1Id` = ?,`cateLev2Id` = ?,`cateLev3Id` = ?,`cateLev4Id` = ?,`timeStamp` = ?,`subtitleSelectId` = ?,`totalDuration` = ?,`subjectDurationSeconds` = ?,`averageHueLight` = ?,`subjectType` = ?,`hasDelete` = ?,`playMode` = ?,`downloadUrl` = ?,`downloadResid` = ?,`downloadFilePath` = ?,`downloadSize` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`rewardPlayed` = ?,`rewardUnlock` = ?,`rewardFree` = ?,`ops` = ?,`uid` = ?,`userName` = ?,`userAvatar` = ?,`description` = ?,`videoStyle` = ?,`kidId` = ? WHERE `collectionId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, UGCVideoDetailPlayBean uGCVideoDetailPlayBean) {
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, uGCVideoDetailPlayBean.getCollectionId());
            }
            if (uGCVideoDetailPlayBean.getUgcVideoId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, uGCVideoDetailPlayBean.getUgcVideoId());
            }
            eVar.c(3, uGCVideoDetailPlayBean.getProgress());
            if (uGCVideoDetailPlayBean.getTitle() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, uGCVideoDetailPlayBean.getTitle());
            }
            if (uGCVideoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, uGCVideoDetailPlayBean.getCoverUrl());
            }
            if (uGCVideoDetailPlayBean.getThumbnail() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, uGCVideoDetailPlayBean.getThumbnail());
            }
            eVar.c(7, uGCVideoDetailPlayBean.getPosition());
            if (uGCVideoDetailPlayBean.getType() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, uGCVideoDetailPlayBean.getType());
            }
            if (uGCVideoDetailPlayBean.getCateLev1Id() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, uGCVideoDetailPlayBean.getCateLev1Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev2Id() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, uGCVideoDetailPlayBean.getCateLev2Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev3Id() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, uGCVideoDetailPlayBean.getCateLev3Id().intValue());
            }
            if (uGCVideoDetailPlayBean.getCateLev4Id() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, uGCVideoDetailPlayBean.getCateLev4Id().intValue());
            }
            eVar.c(13, uGCVideoDetailPlayBean.getTimeStamp());
            if (uGCVideoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, uGCVideoDetailPlayBean.getSubtitleSelectId());
            }
            if (uGCVideoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, uGCVideoDetailPlayBean.getTotalDuration().longValue());
            }
            if (uGCVideoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(16);
            } else {
                eVar.c(16, uGCVideoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (uGCVideoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(17);
            } else {
                eVar.j(17, uGCVideoDetailPlayBean.getAverageHueLight());
            }
            if (uGCVideoDetailPlayBean.getSubjectType() == null) {
                eVar.g(18);
            } else {
                eVar.c(18, uGCVideoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(19, uGCVideoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getPlayMode() == null) {
                eVar.g(20);
            } else {
                eVar.j(20, uGCVideoDetailPlayBean.getPlayMode());
            }
            if (uGCVideoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(21);
            } else {
                eVar.j(21, uGCVideoDetailPlayBean.getDownloadUrl());
            }
            if (uGCVideoDetailPlayBean.getDownloadResid() == null) {
                eVar.g(22);
            } else {
                eVar.j(22, uGCVideoDetailPlayBean.getDownloadResid());
            }
            if (uGCVideoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(23);
            } else {
                eVar.j(23, uGCVideoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(24, uGCVideoDetailPlayBean.getDownloadSize());
            if (uGCVideoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(25);
            } else {
                eVar.c(25, uGCVideoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (uGCVideoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(26);
            } else {
                eVar.c(26, uGCVideoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(27, uGCVideoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(28, uGCVideoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(29, uGCVideoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (uGCVideoDetailPlayBean.getOps() == null) {
                eVar.g(30);
            } else {
                eVar.j(30, uGCVideoDetailPlayBean.getOps());
            }
            if (uGCVideoDetailPlayBean.getUid() == null) {
                eVar.g(31);
            } else {
                eVar.j(31, uGCVideoDetailPlayBean.getUid());
            }
            if (uGCVideoDetailPlayBean.getUserName() == null) {
                eVar.g(32);
            } else {
                eVar.j(32, uGCVideoDetailPlayBean.getUserName());
            }
            if (uGCVideoDetailPlayBean.getUserAvatar() == null) {
                eVar.g(33);
            } else {
                eVar.j(33, uGCVideoDetailPlayBean.getUserAvatar());
            }
            if (uGCVideoDetailPlayBean.getDescription() == null) {
                eVar.g(34);
            } else {
                eVar.j(34, uGCVideoDetailPlayBean.getDescription());
            }
            if (uGCVideoDetailPlayBean.getVideoStyle() == null) {
                eVar.g(35);
            } else {
                eVar.j(35, uGCVideoDetailPlayBean.getVideoStyle());
            }
            if (uGCVideoDetailPlayBean.getKidId() == null) {
                eVar.g(36);
            } else {
                eVar.j(36, uGCVideoDetailPlayBean.getKidId());
            }
            if (uGCVideoDetailPlayBean.getCollectionId() == null) {
                eVar.g(37);
            } else {
                eVar.j(37, uGCVideoDetailPlayBean.getCollectionId());
            }
        }
    }

    public n0(RoomDatabase roomDatabase) {
        this.f43247a = roomDatabase;
    }

    public static List P() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Q(z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM UGC_VIDEO_DETAIL_PLAY");
        try {
            D0.A0();
            return Unit.f67184a;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit R(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM UGC_VIDEO_DETAIL_PLAY WHERE ugcVideoId=?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List S(String str, int i11, int i12, z3.b bVar) {
        int i13;
        String n02;
        int i14;
        int i15;
        Integer valueOf;
        String n03;
        int i16;
        Long valueOf2;
        int i17;
        int i18;
        Long valueOf3;
        int i19;
        String str2;
        int i20;
        Integer valueOf4;
        int i21;
        int i22;
        boolean z10;
        String n04;
        int i23;
        String n05;
        int i24;
        int i25;
        String n06;
        int i26;
        String n07;
        int i27;
        Long valueOf5;
        int i28;
        int i29;
        Long valueOf6;
        int i30;
        int i31;
        boolean z11;
        int i32;
        boolean z12;
        int i33;
        boolean z13;
        String n08;
        int i34;
        String n09;
        int i35;
        int i36;
        String n010;
        int i37;
        String n011;
        int i38;
        String n012;
        int i39;
        String n013;
        int i40;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE kidId = ? AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' AND rowid IN (SELECT rowid FROM (SELECT rowid, collectionId, MAX(timeStamp) as maxTimeStamp FROM ugc_video_detail_play WHERE kidId = ? AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' GROUP BY collectionId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.c(3, i11);
            D0.c(4, i12);
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n014 = D0.isNull(d11) ? null : D0.n0(d11);
                String n015 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n016 = D0.isNull(d14) ? null : D0.n0(d14);
                String n017 = D0.isNull(d15) ? null : D0.n0(d15);
                if (D0.isNull(d16)) {
                    i14 = d12;
                    i13 = d13;
                    n02 = null;
                } else {
                    i13 = d13;
                    n02 = D0.n0(d16);
                    i14 = d12;
                }
                int i41 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                if (D0.isNull(d19)) {
                    i15 = d14;
                    valueOf = null;
                } else {
                    i15 = d14;
                    valueOf = Integer.valueOf((int) D0.getLong(d19));
                }
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i16 = d25;
                    n03 = null;
                } else {
                    n03 = D0.n0(d24);
                    i16 = d25;
                }
                if (D0.isNull(i16)) {
                    i17 = d26;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i16));
                    i17 = d26;
                }
                if (D0.isNull(i17)) {
                    i18 = d11;
                    valueOf3 = null;
                } else {
                    i18 = d11;
                    valueOf3 = Long.valueOf(D0.getLong(i17));
                }
                int i42 = d27;
                if (D0.isNull(i42)) {
                    d27 = i42;
                    i19 = d28;
                    str2 = null;
                } else {
                    String n019 = D0.n0(i42);
                    d27 = i42;
                    i19 = d28;
                    str2 = n019;
                }
                if (D0.isNull(i19)) {
                    i20 = i16;
                    d26 = i17;
                    i21 = d29;
                    valueOf4 = null;
                } else {
                    i20 = i16;
                    d26 = i17;
                    valueOf4 = Integer.valueOf((int) D0.getLong(i19));
                    i21 = d29;
                }
                int i43 = d15;
                if (((int) D0.getLong(i21)) != 0) {
                    i22 = d30;
                    z10 = true;
                } else {
                    i22 = d30;
                    z10 = false;
                }
                if (D0.isNull(i22)) {
                    i23 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i22);
                    i23 = d31;
                }
                if (D0.isNull(i23)) {
                    i24 = i19;
                    i25 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i23);
                    i24 = i19;
                    i25 = d32;
                }
                if (D0.isNull(i25)) {
                    d32 = i25;
                    i26 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i25);
                    d32 = i25;
                    i26 = d33;
                }
                if (D0.isNull(i26)) {
                    d33 = i26;
                    i27 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i26);
                    d33 = i26;
                    i27 = d34;
                }
                long j13 = D0.getLong(i27);
                d34 = i27;
                int i44 = d35;
                if (D0.isNull(i44)) {
                    d35 = i44;
                    i28 = d36;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i44));
                    d35 = i44;
                    i28 = d36;
                }
                if (D0.isNull(i28)) {
                    d36 = i28;
                    i29 = i22;
                    i30 = d37;
                    valueOf6 = null;
                } else {
                    i29 = i22;
                    valueOf6 = Long.valueOf(D0.getLong(i28));
                    d36 = i28;
                    i30 = d37;
                }
                int i45 = i21;
                if (((int) D0.getLong(i30)) != 0) {
                    i31 = d38;
                    z11 = true;
                } else {
                    i31 = d38;
                    z11 = false;
                }
                int i46 = i23;
                if (((int) D0.getLong(i31)) != 0) {
                    i32 = d39;
                    z12 = true;
                } else {
                    i32 = d39;
                    z12 = false;
                }
                int i47 = d16;
                if (((int) D0.getLong(i32)) != 0) {
                    i33 = d40;
                    z13 = true;
                } else {
                    i33 = d40;
                    z13 = false;
                }
                if (D0.isNull(i33)) {
                    i34 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i33);
                    i34 = d41;
                }
                if (D0.isNull(i34)) {
                    i35 = i30;
                    i36 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i34);
                    i35 = i30;
                    i36 = d42;
                }
                if (D0.isNull(i36)) {
                    d42 = i36;
                    i37 = d43;
                    n010 = null;
                } else {
                    d42 = i36;
                    n010 = D0.n0(i36);
                    i37 = d43;
                }
                if (D0.isNull(i37)) {
                    d43 = i37;
                    i38 = d44;
                    n011 = null;
                } else {
                    d43 = i37;
                    n011 = D0.n0(i37);
                    i38 = d44;
                }
                if (D0.isNull(i38)) {
                    d44 = i38;
                    i39 = d45;
                    n012 = null;
                } else {
                    d44 = i38;
                    n012 = D0.n0(i38);
                    i39 = d45;
                }
                if (D0.isNull(i39)) {
                    d45 = i39;
                    i40 = d46;
                    n013 = null;
                } else {
                    d45 = i39;
                    n013 = D0.n0(i39);
                    i40 = d46;
                }
                d46 = i40;
                arrayList.add(new UGCVideoDetailPlayBean(n014, n015, j11, n016, n017, n02, i41, n018, valueOf, valueOf7, valueOf8, valueOf9, j12, n03, valueOf2, valueOf3, str2, valueOf4, z10, n04, n05, n06, n07, j13, valueOf5, valueOf6, z11, z12, z13, n08, n09, n010, n011, n012, n013, D0.isNull(i40) ? null : D0.n0(i40)));
                d11 = i18;
                d40 = i33;
                d41 = i34;
                d25 = i20;
                d15 = i43;
                d28 = i24;
                d29 = i45;
                d31 = i46;
                d16 = i47;
                d12 = i14;
                d38 = i31;
                d39 = i32;
                d37 = i35;
                d13 = i13;
                d14 = i15;
                d30 = i29;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List T(int i11, int i12, z3.b bVar) {
        int i13;
        String n02;
        int i14;
        int i15;
        Integer valueOf;
        String n03;
        int i16;
        Long valueOf2;
        int i17;
        int i18;
        Long valueOf3;
        String n04;
        int i19;
        int i20;
        int i21;
        Integer valueOf4;
        int i22;
        int i23;
        boolean z10;
        String n05;
        int i24;
        String n06;
        int i25;
        int i26;
        String n07;
        int i27;
        String n08;
        int i28;
        Long valueOf5;
        int i29;
        int i30;
        Long valueOf6;
        int i31;
        int i32;
        boolean z11;
        int i33;
        boolean z12;
        int i34;
        boolean z13;
        String n09;
        int i35;
        String n010;
        int i36;
        String n011;
        int i37;
        String n012;
        int i38;
        String n013;
        int i39;
        String n014;
        int i40;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE (kidId IS NULL OR kidId = '') AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' AND rowid IN (SELECT rowid FROM (SELECT rowid, collectionId, MAX(timeStamp) as maxTimeStamp FROM ugc_video_detail_play WHERE (kidId IS NULL OR kidId = '') AND coverUrl IS NOT NULL AND collectionId NOT LIKE 'SINGLE_%' GROUP BY collectionId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            D0.c(1, i11);
            D0.c(2, i12);
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n015 = D0.isNull(d11) ? null : D0.n0(d11);
                String n016 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n017 = D0.isNull(d14) ? null : D0.n0(d14);
                String n018 = D0.isNull(d15) ? null : D0.n0(d15);
                if (D0.isNull(d16)) {
                    i14 = d11;
                    i13 = d12;
                    n02 = null;
                } else {
                    i13 = d12;
                    n02 = D0.n0(d16);
                    i14 = d11;
                }
                int i41 = (int) D0.getLong(d17);
                String n019 = D0.isNull(d18) ? null : D0.n0(d18);
                if (D0.isNull(d19)) {
                    i15 = d13;
                    valueOf = null;
                } else {
                    i15 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d19));
                }
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i16 = d25;
                    n03 = null;
                } else {
                    n03 = D0.n0(d24);
                    i16 = d25;
                }
                if (D0.isNull(i16)) {
                    i17 = d26;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i16));
                    i17 = d26;
                }
                if (D0.isNull(i17)) {
                    d25 = i16;
                    i18 = d27;
                    valueOf3 = null;
                } else {
                    d25 = i16;
                    i18 = d27;
                    valueOf3 = Long.valueOf(D0.getLong(i17));
                }
                if (D0.isNull(i18)) {
                    d27 = i18;
                    i19 = d28;
                    n04 = null;
                } else {
                    n04 = D0.n0(i18);
                    d27 = i18;
                    i19 = d28;
                }
                if (D0.isNull(i19)) {
                    i20 = i17;
                    i21 = d14;
                    i22 = d29;
                    valueOf4 = null;
                } else {
                    i20 = i17;
                    i21 = d14;
                    valueOf4 = Integer.valueOf((int) D0.getLong(i19));
                    i22 = d29;
                }
                int i42 = d15;
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d30;
                    z10 = true;
                } else {
                    i23 = d30;
                    z10 = false;
                }
                if (D0.isNull(i23)) {
                    i24 = d31;
                    n05 = null;
                } else {
                    n05 = D0.n0(i23);
                    i24 = d31;
                }
                if (D0.isNull(i24)) {
                    i25 = i19;
                    i26 = d32;
                    n06 = null;
                } else {
                    n06 = D0.n0(i24);
                    i25 = i19;
                    i26 = d32;
                }
                if (D0.isNull(i26)) {
                    d32 = i26;
                    i27 = d33;
                    n07 = null;
                } else {
                    n07 = D0.n0(i26);
                    d32 = i26;
                    i27 = d33;
                }
                if (D0.isNull(i27)) {
                    d33 = i27;
                    i28 = d34;
                    n08 = null;
                } else {
                    n08 = D0.n0(i27);
                    d33 = i27;
                    i28 = d34;
                }
                long j13 = D0.getLong(i28);
                d34 = i28;
                int i43 = d35;
                if (D0.isNull(i43)) {
                    d35 = i43;
                    i29 = d36;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i43));
                    d35 = i43;
                    i29 = d36;
                }
                if (D0.isNull(i29)) {
                    d36 = i29;
                    i30 = i23;
                    i31 = d37;
                    valueOf6 = null;
                } else {
                    i30 = i23;
                    valueOf6 = Long.valueOf(D0.getLong(i29));
                    d36 = i29;
                    i31 = d37;
                }
                int i44 = i22;
                if (((int) D0.getLong(i31)) != 0) {
                    i32 = d38;
                    z11 = true;
                } else {
                    i32 = d38;
                    z11 = false;
                }
                int i45 = i24;
                int i46 = i31;
                if (((int) D0.getLong(i32)) != 0) {
                    i33 = d39;
                    z12 = true;
                } else {
                    i33 = d39;
                    z12 = false;
                }
                int i47 = i32;
                if (((int) D0.getLong(i33)) != 0) {
                    i34 = d40;
                    z13 = true;
                } else {
                    i34 = d40;
                    z13 = false;
                }
                if (D0.isNull(i34)) {
                    i35 = d41;
                    n09 = null;
                } else {
                    n09 = D0.n0(i34);
                    i35 = d41;
                }
                if (D0.isNull(i35)) {
                    d40 = i34;
                    i36 = d42;
                    n010 = null;
                } else {
                    d40 = i34;
                    n010 = D0.n0(i35);
                    i36 = d42;
                }
                if (D0.isNull(i36)) {
                    d42 = i36;
                    i37 = d43;
                    n011 = null;
                } else {
                    d42 = i36;
                    n011 = D0.n0(i36);
                    i37 = d43;
                }
                if (D0.isNull(i37)) {
                    d43 = i37;
                    i38 = d44;
                    n012 = null;
                } else {
                    d43 = i37;
                    n012 = D0.n0(i37);
                    i38 = d44;
                }
                if (D0.isNull(i38)) {
                    d44 = i38;
                    i39 = d45;
                    n013 = null;
                } else {
                    d44 = i38;
                    n013 = D0.n0(i38);
                    i39 = d45;
                }
                if (D0.isNull(i39)) {
                    d45 = i39;
                    i40 = d46;
                    n014 = null;
                } else {
                    d45 = i39;
                    n014 = D0.n0(i39);
                    i40 = d46;
                }
                d46 = i40;
                arrayList.add(new UGCVideoDetailPlayBean(n015, n016, j11, n017, n018, n02, i41, n019, valueOf, valueOf7, valueOf8, valueOf9, j12, n03, valueOf2, valueOf3, n04, valueOf4, z10, n05, n06, n07, n08, j13, valueOf5, valueOf6, z11, z12, z13, n09, n010, n011, n012, n013, n014, D0.isNull(i40) ? null : D0.n0(i40)));
                d41 = i35;
                d11 = i14;
                d12 = i13;
                d13 = i15;
                d30 = i30;
                int i48 = i33;
                d14 = i21;
                d26 = i20;
                d28 = i25;
                d31 = i45;
                d38 = i47;
                d39 = i48;
                d37 = i46;
                d15 = i42;
                d29 = i44;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean U(String str, z3.b bVar) {
        String n02;
        int i11;
        Long valueOf;
        int i12;
        Long valueOf2;
        int i13;
        String n03;
        int i14;
        Integer valueOf3;
        int i15;
        boolean z10;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        int i19;
        String n07;
        int i20;
        Long valueOf4;
        int i21;
        Long valueOf5;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        int i24;
        boolean z13;
        int i25;
        String n08;
        int i26;
        String n09;
        int i27;
        String n010;
        int i28;
        String n011;
        int i29;
        String n012;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM UGC_VIDEO_DETAIL_PLAY WHERE ugcVideoId = ? AND collectionId NOT LIKE 'SINGLE_%' ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (D0.A0()) {
                String n013 = D0.isNull(d11) ? null : D0.n0(d11);
                String n014 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n015 = D0.isNull(d14) ? null : D0.n0(d14);
                String n016 = D0.isNull(d15) ? null : D0.n0(d15);
                String n017 = D0.isNull(d16) ? null : D0.n0(d16);
                int i31 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                Integer valueOf6 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(D0.getLong(i11));
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i12));
                    i13 = d27;
                }
                if (D0.isNull(i13)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d28;
                }
                if (D0.isNull(i14)) {
                    i15 = d29;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d29;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d30;
                    z10 = true;
                } else {
                    z10 = false;
                    i16 = d30;
                }
                if (D0.isNull(i16)) {
                    i17 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d31;
                }
                if (D0.isNull(i17)) {
                    i18 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d32;
                }
                if (D0.isNull(i18)) {
                    i19 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i18);
                    i19 = d33;
                }
                if (D0.isNull(i19)) {
                    i20 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i19);
                    i20 = d34;
                }
                long j13 = D0.getLong(i20);
                if (D0.isNull(d35)) {
                    i21 = d36;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(d35));
                    i21 = d36;
                }
                if (D0.isNull(i21)) {
                    i22 = d37;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i21));
                    i22 = d37;
                }
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i23 = d38;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i24 = d39;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i25 = d40;
                }
                if (D0.isNull(i25)) {
                    i26 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i25);
                    i26 = d41;
                }
                if (D0.isNull(i26)) {
                    i27 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i26);
                    i27 = d42;
                }
                if (D0.isNull(i27)) {
                    i28 = d43;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    i28 = d43;
                }
                if (D0.isNull(i28)) {
                    i29 = d44;
                    n011 = null;
                } else {
                    n011 = D0.n0(i28);
                    i29 = d44;
                }
                if (D0.isNull(i29)) {
                    i30 = d45;
                    n012 = null;
                } else {
                    n012 = D0.n0(i29);
                    i30 = d45;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(n013, n014, j11, n015, n016, n017, i31, n018, valueOf6, valueOf7, valueOf8, valueOf9, j12, n02, valueOf, valueOf2, n03, valueOf3, z10, n04, n05, n06, n07, j13, valueOf4, valueOf5, z11, z12, z13, n08, n09, n010, n011, n012, D0.isNull(i30) ? null : D0.n0(i30), D0.isNull(d46) ? null : D0.n0(d46));
            }
            D0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean V(String str, z3.b bVar) {
        String n02;
        int i11;
        Long valueOf;
        int i12;
        Long valueOf2;
        int i13;
        String n03;
        int i14;
        Integer valueOf3;
        int i15;
        boolean z10;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        int i19;
        String n07;
        int i20;
        Long valueOf4;
        int i21;
        Long valueOf5;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        int i24;
        boolean z13;
        int i25;
        String n08;
        int i26;
        String n09;
        int i27;
        String n010;
        int i28;
        String n011;
        int i29;
        String n012;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM UGC_VIDEO_DETAIL_PLAY WHERE collectionId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (D0.A0()) {
                String n013 = D0.isNull(d11) ? null : D0.n0(d11);
                String n014 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n015 = D0.isNull(d14) ? null : D0.n0(d14);
                String n016 = D0.isNull(d15) ? null : D0.n0(d15);
                String n017 = D0.isNull(d16) ? null : D0.n0(d16);
                int i31 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                Integer valueOf6 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(D0.getLong(i11));
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i12));
                    i13 = d27;
                }
                if (D0.isNull(i13)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d28;
                }
                if (D0.isNull(i14)) {
                    i15 = d29;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d29;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d30;
                    z10 = true;
                } else {
                    z10 = false;
                    i16 = d30;
                }
                if (D0.isNull(i16)) {
                    i17 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d31;
                }
                if (D0.isNull(i17)) {
                    i18 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d32;
                }
                if (D0.isNull(i18)) {
                    i19 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i18);
                    i19 = d33;
                }
                if (D0.isNull(i19)) {
                    i20 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i19);
                    i20 = d34;
                }
                long j13 = D0.getLong(i20);
                if (D0.isNull(d35)) {
                    i21 = d36;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(d35));
                    i21 = d36;
                }
                if (D0.isNull(i21)) {
                    i22 = d37;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i21));
                    i22 = d37;
                }
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i23 = d38;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i24 = d39;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i25 = d40;
                }
                if (D0.isNull(i25)) {
                    i26 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i25);
                    i26 = d41;
                }
                if (D0.isNull(i26)) {
                    i27 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i26);
                    i27 = d42;
                }
                if (D0.isNull(i27)) {
                    i28 = d43;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    i28 = d43;
                }
                if (D0.isNull(i28)) {
                    i29 = d44;
                    n011 = null;
                } else {
                    n011 = D0.n0(i28);
                    i29 = d44;
                }
                if (D0.isNull(i29)) {
                    i30 = d45;
                    n012 = null;
                } else {
                    n012 = D0.n0(i29);
                    i30 = d45;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(n013, n014, j11, n015, n016, n017, i31, n018, valueOf6, valueOf7, valueOf8, valueOf9, j12, n02, valueOf, valueOf2, n03, valueOf3, z10, n04, n05, n06, n07, j13, valueOf4, valueOf5, z11, z12, z13, n08, n09, n010, n011, n012, D0.isNull(i30) ? null : D0.n0(i30), D0.isNull(d46) ? null : D0.n0(d46));
            }
            D0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean W(String str, String str2, z3.b bVar) {
        String n02;
        int i11;
        Long valueOf;
        int i12;
        Long valueOf2;
        int i13;
        String n03;
        int i14;
        Integer valueOf3;
        int i15;
        boolean z10;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        int i19;
        String n07;
        int i20;
        Long valueOf4;
        int i21;
        Long valueOf5;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        int i24;
        boolean z13;
        int i25;
        String n08;
        int i26;
        String n09;
        int i27;
        String n010;
        int i28;
        String n011;
        int i29;
        String n012;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM UGC_VIDEO_DETAIL_PLAY WHERE ugcVideoId = ? AND collectionId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (D0.A0()) {
                String n013 = D0.isNull(d11) ? null : D0.n0(d11);
                String n014 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n015 = D0.isNull(d14) ? null : D0.n0(d14);
                String n016 = D0.isNull(d15) ? null : D0.n0(d15);
                String n017 = D0.isNull(d16) ? null : D0.n0(d16);
                int i31 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                Integer valueOf6 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(D0.getLong(i11));
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i12));
                    i13 = d27;
                }
                if (D0.isNull(i13)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d28;
                }
                if (D0.isNull(i14)) {
                    i15 = d29;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d29;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d30;
                    z10 = true;
                } else {
                    z10 = false;
                    i16 = d30;
                }
                if (D0.isNull(i16)) {
                    i17 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d31;
                }
                if (D0.isNull(i17)) {
                    i18 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d32;
                }
                if (D0.isNull(i18)) {
                    i19 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i18);
                    i19 = d33;
                }
                if (D0.isNull(i19)) {
                    i20 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i19);
                    i20 = d34;
                }
                long j13 = D0.getLong(i20);
                if (D0.isNull(d35)) {
                    i21 = d36;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(d35));
                    i21 = d36;
                }
                if (D0.isNull(i21)) {
                    i22 = d37;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i21));
                    i22 = d37;
                }
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i23 = d38;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i24 = d39;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i25 = d40;
                }
                if (D0.isNull(i25)) {
                    i26 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i25);
                    i26 = d41;
                }
                if (D0.isNull(i26)) {
                    i27 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i26);
                    i27 = d42;
                }
                if (D0.isNull(i27)) {
                    i28 = d43;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    i28 = d43;
                }
                if (D0.isNull(i28)) {
                    i29 = d44;
                    n011 = null;
                } else {
                    n011 = D0.n0(i28);
                    i29 = d44;
                }
                if (D0.isNull(i29)) {
                    i30 = d45;
                    n012 = null;
                } else {
                    n012 = D0.n0(i29);
                    i30 = d45;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(n013, n014, j11, n015, n016, n017, i31, n018, valueOf6, valueOf7, valueOf8, valueOf9, j12, n02, valueOf, valueOf2, n03, valueOf3, z10, n04, n05, n06, n07, j13, valueOf4, valueOf5, z11, z12, z13, n08, n09, n010, n011, n012, D0.isNull(i30) ? null : D0.n0(i30), D0.isNull(d46) ? null : D0.n0(d46));
            }
            D0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean X(String str, String str2, z3.b bVar) {
        String n02;
        int i11;
        Long valueOf;
        int i12;
        Long valueOf2;
        int i13;
        String n03;
        int i14;
        Integer valueOf3;
        int i15;
        boolean z10;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        int i19;
        String n07;
        int i20;
        Long valueOf4;
        int i21;
        Long valueOf5;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        int i24;
        boolean z13;
        int i25;
        String n08;
        int i26;
        String n09;
        int i27;
        String n010;
        int i28;
        String n011;
        int i29;
        String n012;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND kidId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (D0.A0()) {
                String n013 = D0.isNull(d11) ? null : D0.n0(d11);
                String n014 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n015 = D0.isNull(d14) ? null : D0.n0(d14);
                String n016 = D0.isNull(d15) ? null : D0.n0(d15);
                String n017 = D0.isNull(d16) ? null : D0.n0(d16);
                int i31 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                Integer valueOf6 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(D0.getLong(i11));
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i12));
                    i13 = d27;
                }
                if (D0.isNull(i13)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d28;
                }
                if (D0.isNull(i14)) {
                    i15 = d29;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d29;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d30;
                    z10 = true;
                } else {
                    z10 = false;
                    i16 = d30;
                }
                if (D0.isNull(i16)) {
                    i17 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d31;
                }
                if (D0.isNull(i17)) {
                    i18 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d32;
                }
                if (D0.isNull(i18)) {
                    i19 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i18);
                    i19 = d33;
                }
                if (D0.isNull(i19)) {
                    i20 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i19);
                    i20 = d34;
                }
                long j13 = D0.getLong(i20);
                if (D0.isNull(d35)) {
                    i21 = d36;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(d35));
                    i21 = d36;
                }
                if (D0.isNull(i21)) {
                    i22 = d37;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i21));
                    i22 = d37;
                }
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i23 = d38;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i24 = d39;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i25 = d40;
                }
                if (D0.isNull(i25)) {
                    i26 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i25);
                    i26 = d41;
                }
                if (D0.isNull(i26)) {
                    i27 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i26);
                    i27 = d42;
                }
                if (D0.isNull(i27)) {
                    i28 = d43;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    i28 = d43;
                }
                if (D0.isNull(i28)) {
                    i29 = d44;
                    n011 = null;
                } else {
                    n011 = D0.n0(i28);
                    i29 = d44;
                }
                if (D0.isNull(i29)) {
                    i30 = d45;
                    n012 = null;
                } else {
                    n012 = D0.n0(i29);
                    i30 = d45;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(n013, n014, j11, n015, n016, n017, i31, n018, valueOf6, valueOf7, valueOf8, valueOf9, j12, n02, valueOf, valueOf2, n03, valueOf3, z10, n04, n05, n06, n07, j13, valueOf4, valueOf5, z11, z12, z13, n08, n09, n010, n011, n012, D0.isNull(i30) ? null : D0.n0(i30), D0.isNull(d46) ? null : D0.n0(d46));
            }
            D0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean Y(String str, z3.b bVar) {
        String n02;
        int i11;
        Long valueOf;
        int i12;
        Long valueOf2;
        int i13;
        String n03;
        int i14;
        Integer valueOf3;
        int i15;
        boolean z10;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        int i19;
        String n07;
        int i20;
        Long valueOf4;
        int i21;
        Long valueOf5;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        int i24;
        boolean z13;
        int i25;
        String n08;
        int i26;
        String n09;
        int i27;
        String n010;
        int i28;
        String n011;
        int i29;
        String n012;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND (kidId IS NULL OR kidId = '') ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (D0.A0()) {
                String n013 = D0.isNull(d11) ? null : D0.n0(d11);
                String n014 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n015 = D0.isNull(d14) ? null : D0.n0(d14);
                String n016 = D0.isNull(d15) ? null : D0.n0(d15);
                String n017 = D0.isNull(d16) ? null : D0.n0(d16);
                int i31 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                Integer valueOf6 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(D0.getLong(i11));
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i12));
                    i13 = d27;
                }
                if (D0.isNull(i13)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d28;
                }
                if (D0.isNull(i14)) {
                    i15 = d29;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d29;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d30;
                    z10 = true;
                } else {
                    z10 = false;
                    i16 = d30;
                }
                if (D0.isNull(i16)) {
                    i17 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d31;
                }
                if (D0.isNull(i17)) {
                    i18 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d32;
                }
                if (D0.isNull(i18)) {
                    i19 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i18);
                    i19 = d33;
                }
                if (D0.isNull(i19)) {
                    i20 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i19);
                    i20 = d34;
                }
                long j13 = D0.getLong(i20);
                if (D0.isNull(d35)) {
                    i21 = d36;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(d35));
                    i21 = d36;
                }
                if (D0.isNull(i21)) {
                    i22 = d37;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i21));
                    i22 = d37;
                }
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i23 = d38;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i24 = d39;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i25 = d40;
                }
                if (D0.isNull(i25)) {
                    i26 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i25);
                    i26 = d41;
                }
                if (D0.isNull(i26)) {
                    i27 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i26);
                    i27 = d42;
                }
                if (D0.isNull(i27)) {
                    i28 = d43;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    i28 = d43;
                }
                if (D0.isNull(i28)) {
                    i29 = d44;
                    n011 = null;
                } else {
                    n011 = D0.n0(i28);
                    i29 = d44;
                }
                if (D0.isNull(i29)) {
                    i30 = d45;
                    n012 = null;
                } else {
                    n012 = D0.n0(i29);
                    i30 = d45;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(n013, n014, j11, n015, n016, n017, i31, n018, valueOf6, valueOf7, valueOf8, valueOf9, j12, n02, valueOf, valueOf2, n03, valueOf3, z10, n04, n05, n06, n07, j13, valueOf4, valueOf5, z11, z12, z13, n08, n09, n010, n011, n012, D0.isNull(i30) ? null : D0.n0(i30), D0.isNull(d46) ? null : D0.n0(d46));
            }
            D0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean Z(String str, String str2, String str3, z3.b bVar) {
        String n02;
        int i11;
        Long valueOf;
        int i12;
        Long valueOf2;
        int i13;
        String n03;
        int i14;
        Integer valueOf3;
        int i15;
        boolean z10;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        int i19;
        String n07;
        int i20;
        Long valueOf4;
        int i21;
        Long valueOf5;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        int i24;
        boolean z13;
        int i25;
        String n08;
        int i26;
        String n09;
        int i27;
        String n010;
        int i28;
        String n011;
        int i29;
        String n012;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND ugcVideoId = ? AND kidId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
            }
            if (str3 == null) {
                D0.g(3);
            } else {
                D0.j(3, str3);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (D0.A0()) {
                String n013 = D0.isNull(d11) ? null : D0.n0(d11);
                String n014 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n015 = D0.isNull(d14) ? null : D0.n0(d14);
                String n016 = D0.isNull(d15) ? null : D0.n0(d15);
                String n017 = D0.isNull(d16) ? null : D0.n0(d16);
                int i31 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                Integer valueOf6 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(D0.getLong(i11));
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i12));
                    i13 = d27;
                }
                if (D0.isNull(i13)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d28;
                }
                if (D0.isNull(i14)) {
                    i15 = d29;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d29;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d30;
                    z10 = true;
                } else {
                    z10 = false;
                    i16 = d30;
                }
                if (D0.isNull(i16)) {
                    i17 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d31;
                }
                if (D0.isNull(i17)) {
                    i18 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d32;
                }
                if (D0.isNull(i18)) {
                    i19 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i18);
                    i19 = d33;
                }
                if (D0.isNull(i19)) {
                    i20 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i19);
                    i20 = d34;
                }
                long j13 = D0.getLong(i20);
                if (D0.isNull(d35)) {
                    i21 = d36;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(d35));
                    i21 = d36;
                }
                if (D0.isNull(i21)) {
                    i22 = d37;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i21));
                    i22 = d37;
                }
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i23 = d38;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i24 = d39;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i25 = d40;
                }
                if (D0.isNull(i25)) {
                    i26 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i25);
                    i26 = d41;
                }
                if (D0.isNull(i26)) {
                    i27 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i26);
                    i27 = d42;
                }
                if (D0.isNull(i27)) {
                    i28 = d43;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    i28 = d43;
                }
                if (D0.isNull(i28)) {
                    i29 = d44;
                    n011 = null;
                } else {
                    n011 = D0.n0(i28);
                    i29 = d44;
                }
                if (D0.isNull(i29)) {
                    i30 = d45;
                    n012 = null;
                } else {
                    n012 = D0.n0(i29);
                    i30 = d45;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(n013, n014, j11, n015, n016, n017, i31, n018, valueOf6, valueOf7, valueOf8, valueOf9, j12, n02, valueOf, valueOf2, n03, valueOf3, z10, n04, n05, n06, n07, j13, valueOf4, valueOf5, z11, z12, z13, n08, n09, n010, n011, n012, D0.isNull(i30) ? null : D0.n0(i30), D0.isNull(d46) ? null : D0.n0(d46));
            }
            D0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UGCVideoDetailPlayBean a0(String str, String str2, z3.b bVar) {
        String n02;
        int i11;
        Long valueOf;
        int i12;
        Long valueOf2;
        int i13;
        String n03;
        int i14;
        Integer valueOf3;
        int i15;
        boolean z10;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        int i19;
        String n07;
        int i20;
        Long valueOf4;
        int i21;
        Long valueOf5;
        int i22;
        boolean z11;
        int i23;
        boolean z12;
        int i24;
        boolean z13;
        int i25;
        String n08;
        int i26;
        String n09;
        int i27;
        String n010;
        int i28;
        String n011;
        int i29;
        String n012;
        int i30;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE collectionId = ? AND ugcVideoId = ? AND (kidId IS NULL OR kidId = '') ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
            }
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            UGCVideoDetailPlayBean uGCVideoDetailPlayBean = null;
            if (D0.A0()) {
                String n013 = D0.isNull(d11) ? null : D0.n0(d11);
                String n014 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n015 = D0.isNull(d14) ? null : D0.n0(d14);
                String n016 = D0.isNull(d15) ? null : D0.n0(d15);
                String n017 = D0.isNull(d16) ? null : D0.n0(d16);
                int i31 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                Integer valueOf6 = D0.isNull(d19) ? null : Integer.valueOf((int) D0.getLong(d19));
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    valueOf = null;
                } else {
                    valueOf = Long.valueOf(D0.getLong(i11));
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i12));
                    i13 = d27;
                }
                if (D0.isNull(i13)) {
                    i14 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d28;
                }
                if (D0.isNull(i14)) {
                    i15 = d29;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf((int) D0.getLong(i14));
                    i15 = d29;
                }
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d30;
                    z10 = true;
                } else {
                    z10 = false;
                    i16 = d30;
                }
                if (D0.isNull(i16)) {
                    i17 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d31;
                }
                if (D0.isNull(i17)) {
                    i18 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d32;
                }
                if (D0.isNull(i18)) {
                    i19 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i18);
                    i19 = d33;
                }
                if (D0.isNull(i19)) {
                    i20 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i19);
                    i20 = d34;
                }
                long j13 = D0.getLong(i20);
                if (D0.isNull(d35)) {
                    i21 = d36;
                    valueOf4 = null;
                } else {
                    valueOf4 = Long.valueOf(D0.getLong(d35));
                    i21 = d36;
                }
                if (D0.isNull(i21)) {
                    i22 = d37;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i21));
                    i22 = d37;
                }
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d38;
                    z11 = true;
                } else {
                    z11 = false;
                    i23 = d38;
                }
                if (((int) D0.getLong(i23)) != 0) {
                    i24 = d39;
                    z12 = true;
                } else {
                    z12 = false;
                    i24 = d39;
                }
                if (((int) D0.getLong(i24)) != 0) {
                    i25 = d40;
                    z13 = true;
                } else {
                    z13 = false;
                    i25 = d40;
                }
                if (D0.isNull(i25)) {
                    i26 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i25);
                    i26 = d41;
                }
                if (D0.isNull(i26)) {
                    i27 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i26);
                    i27 = d42;
                }
                if (D0.isNull(i27)) {
                    i28 = d43;
                    n010 = null;
                } else {
                    n010 = D0.n0(i27);
                    i28 = d43;
                }
                if (D0.isNull(i28)) {
                    i29 = d44;
                    n011 = null;
                } else {
                    n011 = D0.n0(i28);
                    i29 = d44;
                }
                if (D0.isNull(i29)) {
                    i30 = d45;
                    n012 = null;
                } else {
                    n012 = D0.n0(i29);
                    i30 = d45;
                }
                uGCVideoDetailPlayBean = new UGCVideoDetailPlayBean(n013, n014, j11, n015, n016, n017, i31, n018, valueOf6, valueOf7, valueOf8, valueOf9, j12, n02, valueOf, valueOf2, n03, valueOf3, z10, n04, n05, n06, n07, j13, valueOf4, valueOf5, z11, z12, z13, n08, n09, n010, n011, n012, D0.isNull(i30) ? null : D0.n0(i30), D0.isNull(d46) ? null : D0.n0(d46));
            }
            D0.close();
            return uGCVideoDetailPlayBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List b0(String str, int i11, int i12, z3.b bVar) {
        int i13;
        String n02;
        int i14;
        int i15;
        Integer valueOf;
        String n03;
        int i16;
        Long valueOf2;
        int i17;
        int i18;
        Long valueOf3;
        int i19;
        String str2;
        int i20;
        Integer valueOf4;
        int i21;
        int i22;
        boolean z10;
        String n04;
        int i23;
        String n05;
        int i24;
        int i25;
        String n06;
        int i26;
        String n07;
        int i27;
        Long valueOf5;
        int i28;
        int i29;
        Long valueOf6;
        int i30;
        int i31;
        boolean z11;
        int i32;
        boolean z12;
        int i33;
        boolean z13;
        String n08;
        int i34;
        String n09;
        int i35;
        int i36;
        String n010;
        int i37;
        String n011;
        int i38;
        String n012;
        int i39;
        String n013;
        int i40;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE kidId = ? AND coverUrl IS NOT NULL AND collectionId LIKE 'SINGLE_%' ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            D0.c(3, i12);
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n014 = D0.isNull(d11) ? null : D0.n0(d11);
                String n015 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n016 = D0.isNull(d14) ? null : D0.n0(d14);
                String n017 = D0.isNull(d15) ? null : D0.n0(d15);
                if (D0.isNull(d16)) {
                    i14 = d12;
                    i13 = d13;
                    n02 = null;
                } else {
                    i13 = d13;
                    n02 = D0.n0(d16);
                    i14 = d12;
                }
                int i41 = (int) D0.getLong(d17);
                String n018 = D0.isNull(d18) ? null : D0.n0(d18);
                if (D0.isNull(d19)) {
                    i15 = d14;
                    valueOf = null;
                } else {
                    i15 = d14;
                    valueOf = Integer.valueOf((int) D0.getLong(d19));
                }
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i16 = d25;
                    n03 = null;
                } else {
                    n03 = D0.n0(d24);
                    i16 = d25;
                }
                if (D0.isNull(i16)) {
                    i17 = d26;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i16));
                    i17 = d26;
                }
                if (D0.isNull(i17)) {
                    i18 = d11;
                    valueOf3 = null;
                } else {
                    i18 = d11;
                    valueOf3 = Long.valueOf(D0.getLong(i17));
                }
                int i42 = d27;
                if (D0.isNull(i42)) {
                    d27 = i42;
                    i19 = d28;
                    str2 = null;
                } else {
                    String n019 = D0.n0(i42);
                    d27 = i42;
                    i19 = d28;
                    str2 = n019;
                }
                if (D0.isNull(i19)) {
                    i20 = i16;
                    d26 = i17;
                    i21 = d29;
                    valueOf4 = null;
                } else {
                    i20 = i16;
                    d26 = i17;
                    valueOf4 = Integer.valueOf((int) D0.getLong(i19));
                    i21 = d29;
                }
                int i43 = d15;
                if (((int) D0.getLong(i21)) != 0) {
                    i22 = d30;
                    z10 = true;
                } else {
                    i22 = d30;
                    z10 = false;
                }
                if (D0.isNull(i22)) {
                    i23 = d31;
                    n04 = null;
                } else {
                    n04 = D0.n0(i22);
                    i23 = d31;
                }
                if (D0.isNull(i23)) {
                    i24 = i19;
                    i25 = d32;
                    n05 = null;
                } else {
                    n05 = D0.n0(i23);
                    i24 = i19;
                    i25 = d32;
                }
                if (D0.isNull(i25)) {
                    d32 = i25;
                    i26 = d33;
                    n06 = null;
                } else {
                    n06 = D0.n0(i25);
                    d32 = i25;
                    i26 = d33;
                }
                if (D0.isNull(i26)) {
                    d33 = i26;
                    i27 = d34;
                    n07 = null;
                } else {
                    n07 = D0.n0(i26);
                    d33 = i26;
                    i27 = d34;
                }
                long j13 = D0.getLong(i27);
                d34 = i27;
                int i44 = d35;
                if (D0.isNull(i44)) {
                    d35 = i44;
                    i28 = d36;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i44));
                    d35 = i44;
                    i28 = d36;
                }
                if (D0.isNull(i28)) {
                    d36 = i28;
                    i29 = i22;
                    i30 = d37;
                    valueOf6 = null;
                } else {
                    i29 = i22;
                    valueOf6 = Long.valueOf(D0.getLong(i28));
                    d36 = i28;
                    i30 = d37;
                }
                int i45 = i21;
                if (((int) D0.getLong(i30)) != 0) {
                    i31 = d38;
                    z11 = true;
                } else {
                    i31 = d38;
                    z11 = false;
                }
                int i46 = i23;
                if (((int) D0.getLong(i31)) != 0) {
                    i32 = d39;
                    z12 = true;
                } else {
                    i32 = d39;
                    z12 = false;
                }
                int i47 = d16;
                if (((int) D0.getLong(i32)) != 0) {
                    i33 = d40;
                    z13 = true;
                } else {
                    i33 = d40;
                    z13 = false;
                }
                if (D0.isNull(i33)) {
                    i34 = d41;
                    n08 = null;
                } else {
                    n08 = D0.n0(i33);
                    i34 = d41;
                }
                if (D0.isNull(i34)) {
                    i35 = i30;
                    i36 = d42;
                    n09 = null;
                } else {
                    n09 = D0.n0(i34);
                    i35 = i30;
                    i36 = d42;
                }
                if (D0.isNull(i36)) {
                    d42 = i36;
                    i37 = d43;
                    n010 = null;
                } else {
                    d42 = i36;
                    n010 = D0.n0(i36);
                    i37 = d43;
                }
                if (D0.isNull(i37)) {
                    d43 = i37;
                    i38 = d44;
                    n011 = null;
                } else {
                    d43 = i37;
                    n011 = D0.n0(i37);
                    i38 = d44;
                }
                if (D0.isNull(i38)) {
                    d44 = i38;
                    i39 = d45;
                    n012 = null;
                } else {
                    d44 = i38;
                    n012 = D0.n0(i38);
                    i39 = d45;
                }
                if (D0.isNull(i39)) {
                    d45 = i39;
                    i40 = d46;
                    n013 = null;
                } else {
                    d45 = i39;
                    n013 = D0.n0(i39);
                    i40 = d46;
                }
                d46 = i40;
                arrayList.add(new UGCVideoDetailPlayBean(n014, n015, j11, n016, n017, n02, i41, n018, valueOf, valueOf7, valueOf8, valueOf9, j12, n03, valueOf2, valueOf3, str2, valueOf4, z10, n04, n05, n06, n07, j13, valueOf5, valueOf6, z11, z12, z13, n08, n09, n010, n011, n012, n013, D0.isNull(i40) ? null : D0.n0(i40)));
                d11 = i18;
                d40 = i33;
                d41 = i34;
                d25 = i20;
                d15 = i43;
                d28 = i24;
                d29 = i45;
                d31 = i46;
                d16 = i47;
                d12 = i14;
                d38 = i31;
                d39 = i32;
                d37 = i35;
                d13 = i13;
                d14 = i15;
                d30 = i29;
            }
            D0.close();
            return arrayList;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List c0(int i11, int i12, z3.b bVar) {
        int i13;
        String n02;
        int i14;
        int i15;
        Integer valueOf;
        String n03;
        int i16;
        Long valueOf2;
        int i17;
        int i18;
        Long valueOf3;
        String n04;
        int i19;
        int i20;
        int i21;
        Integer valueOf4;
        int i22;
        int i23;
        boolean z10;
        String n05;
        int i24;
        String n06;
        int i25;
        int i26;
        String n07;
        int i27;
        String n08;
        int i28;
        Long valueOf5;
        int i29;
        int i30;
        Long valueOf6;
        int i31;
        int i32;
        boolean z11;
        int i33;
        boolean z12;
        int i34;
        boolean z13;
        String n09;
        int i35;
        String n010;
        int i36;
        String n011;
        int i37;
        String n012;
        int i38;
        String n013;
        int i39;
        String n014;
        int i40;
        z3.e D0 = bVar.D0("SELECT * FROM ugc_video_detail_play WHERE (kidId IS NULL OR kidId = '') AND coverUrl IS NOT NULL AND collectionId LIKE 'SINGLE_%' ORDER BY timeStamp DESC LIMIT ? OFFSET ?");
        try {
            D0.c(1, i11);
            D0.c(2, i12);
            int d11 = androidx.room.util.k.d(D0, "collectionId");
            int d12 = androidx.room.util.k.d(D0, "ugcVideoId");
            int d13 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d14 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d15 = androidx.room.util.k.d(D0, "coverUrl");
            int d16 = androidx.room.util.k.d(D0, "thumbnail");
            int d17 = androidx.room.util.k.d(D0, RequestParameters.POSITION);
            int d18 = androidx.room.util.k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d19 = androidx.room.util.k.d(D0, "cateLev1Id");
            int d20 = androidx.room.util.k.d(D0, "cateLev2Id");
            int d21 = androidx.room.util.k.d(D0, "cateLev3Id");
            int d22 = androidx.room.util.k.d(D0, "cateLev4Id");
            int d23 = androidx.room.util.k.d(D0, "timeStamp");
            int d24 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d25 = androidx.room.util.k.d(D0, "totalDuration");
            int d26 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d27 = androidx.room.util.k.d(D0, "averageHueLight");
            int d28 = androidx.room.util.k.d(D0, "subjectType");
            int d29 = androidx.room.util.k.d(D0, "hasDelete");
            int d30 = androidx.room.util.k.d(D0, "playMode");
            int d31 = androidx.room.util.k.d(D0, "downloadUrl");
            int d32 = androidx.room.util.k.d(D0, "downloadResid");
            int d33 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d34 = androidx.room.util.k.d(D0, "downloadSize");
            int d35 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d36 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d37 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d38 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d39 = androidx.room.util.k.d(D0, "rewardFree");
            int d40 = androidx.room.util.k.d(D0, "ops");
            int d41 = androidx.room.util.k.d(D0, CommonUtils.PARAM_UID);
            int d42 = androidx.room.util.k.d(D0, "userName");
            int d43 = androidx.room.util.k.d(D0, "userAvatar");
            int d44 = androidx.room.util.k.d(D0, TrackingKey.DESCRIPTION);
            int d45 = androidx.room.util.k.d(D0, "videoStyle");
            int d46 = androidx.room.util.k.d(D0, "kidId");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n015 = D0.isNull(d11) ? null : D0.n0(d11);
                String n016 = D0.isNull(d12) ? null : D0.n0(d12);
                long j11 = D0.getLong(d13);
                String n017 = D0.isNull(d14) ? null : D0.n0(d14);
                String n018 = D0.isNull(d15) ? null : D0.n0(d15);
                if (D0.isNull(d16)) {
                    i14 = d11;
                    i13 = d12;
                    n02 = null;
                } else {
                    i13 = d12;
                    n02 = D0.n0(d16);
                    i14 = d11;
                }
                int i41 = (int) D0.getLong(d17);
                String n019 = D0.isNull(d18) ? null : D0.n0(d18);
                if (D0.isNull(d19)) {
                    i15 = d13;
                    valueOf = null;
                } else {
                    i15 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d19));
                }
                Integer valueOf7 = D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20));
                Integer valueOf8 = D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21));
                Integer valueOf9 = D0.isNull(d22) ? null : Integer.valueOf((int) D0.getLong(d22));
                long j12 = D0.getLong(d23);
                if (D0.isNull(d24)) {
                    i16 = d25;
                    n03 = null;
                } else {
                    n03 = D0.n0(d24);
                    i16 = d25;
                }
                if (D0.isNull(i16)) {
                    i17 = d26;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i16));
                    i17 = d26;
                }
                if (D0.isNull(i17)) {
                    d25 = i16;
                    i18 = d27;
                    valueOf3 = null;
                } else {
                    d25 = i16;
                    i18 = d27;
                    valueOf3 = Long.valueOf(D0.getLong(i17));
                }
                if (D0.isNull(i18)) {
                    d27 = i18;
                    i19 = d28;
                    n04 = null;
                } else {
                    n04 = D0.n0(i18);
                    d27 = i18;
                    i19 = d28;
                }
                if (D0.isNull(i19)) {
                    i20 = i17;
                    i21 = d14;
                    i22 = d29;
                    valueOf4 = null;
                } else {
                    i20 = i17;
                    i21 = d14;
                    valueOf4 = Integer.valueOf((int) D0.getLong(i19));
                    i22 = d29;
                }
                int i42 = d15;
                if (((int) D0.getLong(i22)) != 0) {
                    i23 = d30;
                    z10 = true;
                } else {
                    i23 = d30;
                    z10 = false;
                }
                if (D0.isNull(i23)) {
                    i24 = d31;
                    n05 = null;
                } else {
                    n05 = D0.n0(i23);
                    i24 = d31;
                }
                if (D0.isNull(i24)) {
                    i25 = i19;
                    i26 = d32;
                    n06 = null;
                } else {
                    n06 = D0.n0(i24);
                    i25 = i19;
                    i26 = d32;
                }
                if (D0.isNull(i26)) {
                    d32 = i26;
                    i27 = d33;
                    n07 = null;
                } else {
                    n07 = D0.n0(i26);
                    d32 = i26;
                    i27 = d33;
                }
                if (D0.isNull(i27)) {
                    d33 = i27;
                    i28 = d34;
                    n08 = null;
                } else {
                    n08 = D0.n0(i27);
                    d33 = i27;
                    i28 = d34;
                }
                long j13 = D0.getLong(i28);
                d34 = i28;
                int i43 = d35;
                if (D0.isNull(i43)) {
                    d35 = i43;
                    i29 = d36;
                    valueOf5 = null;
                } else {
                    valueOf5 = Long.valueOf(D0.getLong(i43));
                    d35 = i43;
                    i29 = d36;
                }
                if (D0.isNull(i29)) {
                    d36 = i29;
                    i30 = i23;
                    i31 = d37;
                    valueOf6 = null;
                } else {
                    i30 = i23;
                    valueOf6 = Long.valueOf(D0.getLong(i29));
                    d36 = i29;
                    i31 = d37;
                }
                int i44 = i22;
                if (((int) D0.getLong(i31)) != 0) {
                    i32 = d38;
                    z11 = true;
                } else {
                    i32 = d38;
                    z11 = false;
                }
                int i45 = i24;
                int i46 = i31;
                if (((int) D0.getLong(i32)) != 0) {
                    i33 = d39;
                    z12 = true;
                } else {
                    i33 = d39;
                    z12 = false;
                }
                int i47 = i32;
                if (((int) D0.getLong(i33)) != 0) {
                    i34 = d40;
                    z13 = true;
                } else {
                    i34 = d40;
                    z13 = false;
                }
                if (D0.isNull(i34)) {
                    i35 = d41;
                    n09 = null;
                } else {
                    n09 = D0.n0(i34);
                    i35 = d41;
                }
                if (D0.isNull(i35)) {
                    d40 = i34;
                    i36 = d42;
                    n010 = null;
                } else {
                    d40 = i34;
                    n010 = D0.n0(i35);
                    i36 = d42;
                }
                if (D0.isNull(i36)) {
                    d42 = i36;
                    i37 = d43;
                    n011 = null;
                } else {
                    d42 = i36;
                    n011 = D0.n0(i36);
                    i37 = d43;
                }
                if (D0.isNull(i37)) {
                    d43 = i37;
                    i38 = d44;
                    n012 = null;
                } else {
                    d43 = i37;
                    n012 = D0.n0(i37);
                    i38 = d44;
                }
                if (D0.isNull(i38)) {
                    d44 = i38;
                    i39 = d45;
                    n013 = null;
                } else {
                    d44 = i38;
                    n013 = D0.n0(i38);
                    i39 = d45;
                }
                if (D0.isNull(i39)) {
                    d45 = i39;
                    i40 = d46;
                    n014 = null;
                } else {
                    d45 = i39;
                    n014 = D0.n0(i39);
                    i40 = d46;
                }
                d46 = i40;
                arrayList.add(new UGCVideoDetailPlayBean(n015, n016, j11, n017, n018, n02, i41, n019, valueOf, valueOf7, valueOf8, valueOf9, j12, n03, valueOf2, valueOf3, n04, valueOf4, z10, n05, n06, n07, n08, j13, valueOf5, valueOf6, z11, z12, z13, n09, n010, n011, n012, n013, n014, D0.isNull(i40) ? null : D0.n0(i40)));
                d41 = i35;
                d11 = i14;
                d12 = i13;
                d13 = i15;
                d30 = i30;
                int i48 = i33;
                d14 = i21;
                d26 = i20;
                d28 = i25;
                d31 = i45;
                d38 = i47;
                d39 = i48;
                d37 = i46;
                d15 = i42;
                d29 = i44;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit d0(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, z3.b bVar) {
        this.f43248b.d(bVar, uGCVideoDetailPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit e0(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, z3.b bVar) {
        this.f43250d.c(bVar, uGCVideoDetailPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit f0(long j11, String str, long j12, int i11, String str2, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE UGC_VIDEO_DETAIL_PLAY SET progress = ?, ugcVideoId= ?, timeStamp =?, position = ? WHERE collectionId = ? ");
        try {
            D0.c(1, j11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.c(3, j12);
            D0.c(4, i11);
            if (str2 == null) {
                D0.g(5);
            } else {
                D0.j(5, str2);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit g0(String str, String str2, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE UGC_VIDEO_DETAIL_PLAY SET subtitleSelectId = ? WHERE collectionId = ? ");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            if (str2 == null) {
                D0.g(2);
            } else {
                D0.j(2, str2);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h0(long j11, String str, String str2, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE UGC_VIDEO_DETAIL_PLAY SET totalDuration = ?, ugcVideoId= ? WHERE collectionId = ? ");
        try {
            D0.c(1, j11);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            if (str2 == null) {
                D0.g(3);
            } else {
                D0.j(3, str2);
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q;
                Q = n0.Q((z3.b) obj);
                return Q;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g02;
                g02 = n0.g0(str2, str, (z3.b) obj);
                return g02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object c(String str, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.b(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object d(int i11, int i12, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.c(this, i11, i12, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object e(final String str, final String str2, final long j11, final long j12, final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f02;
                f02 = n0.f0(j12, str2, j11, i11, str, (z3.b) obj);
                return f02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object f(final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List T;
                T = n0.T(i12, i11, (z3.b) obj);
                return T;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean V;
                V = n0.V(str, (z3.b) obj);
                return V;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object h(final String str, final String str2, final long j11, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h02;
                h02 = n0.h0(j11, str2, str, (z3.b) obj);
                return h02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object i(final int i11, final int i12, final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List b02;
                b02 = n0.b0(str, i12, i11, (z3.b) obj);
                return b02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object j(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R;
                R = n0.R(str, (z3.b) obj);
                return R;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object k(String str, String str2, long j11, long j12, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.e(this, str, str2, j11, j12, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object l(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.l0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean X;
                X = n0.X(str, str2, (z3.b) obj);
                return X;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object m(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean U;
                U = n0.U(str, (z3.b) obj);
                return U;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object n(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.d(this, uGCVideoDetailPlayBean, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object o(final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List c02;
                c02 = n0.c0(i12, i11, (z3.b) obj);
                return c02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object p(final UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
        uGCVideoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.f43247a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d02;
                d02 = n0.this.d0(uGCVideoDetailPlayBean, (z3.b) obj);
                return d02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object q(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean a02;
                a02 = n0.a0(str, str2, (z3.b) obj);
                return a02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object r(String str, Continuation continuation) {
        return UGCVideoDetailPlayDao.DefaultImpls.a(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object s(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean W;
                W = n0.W(str2, str, (z3.b) obj);
                return W;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object t(final String str, final String str2, final String str3, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean Z;
                Z = n0.Z(str, str2, str3, (z3.b) obj);
                return Z;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object u(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                UGCVideoDetailPlayBean Y;
                Y = n0.Y(str, (z3.b) obj);
                return Y;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object v(final UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation) {
        uGCVideoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.f43247a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e02;
                e02 = n0.this.e0(uGCVideoDetailPlayBean, (z3.b) obj);
                return e02;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.UGCVideoDetailPlayDao
    public Object w(final int i11, final int i12, final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43247a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List S;
                S = n0.S(str, i12, i11, (z3.b) obj);
                return S;
            }
        }, continuation);
    }
}

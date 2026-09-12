package com.transsion.baselib.db.video;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class d1 implements VideoDetailPlayDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43192a;

    /* renamed from: c, reason: collision with root package name */
    private final ij.b f43194c = new ij.b();

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43193b = new a();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f43195d = new b();

    /* renamed from: e, reason: collision with root package name */
    private final androidx.room.e f43196e = new c();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `video_detail_play` (`subjectId`,`id`,`ep`,`se`,`progress`,`title`,`coverUrl`,`thumbnail`,`videoUrl`,`timeStamp`,`subtitleSelectId`,`totalDuration`,`subjectDurationSeconds`,`averageHueLight`,`subjectType`,`hasDelete`,`playMode`,`downloadUrl`,`downloadFilePath`,`downloadSize`,`dubs`,`lastAdStartTimeStamp`,`lastAdEndTimeStamp`,`rewardPlayed`,`rewardUnlock`,`rewardFree`,`ops`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, videoDetailPlayBean.getSubjectId());
            }
            if (videoDetailPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, videoDetailPlayBean.getId());
            }
            eVar.c(3, videoDetailPlayBean.getEp());
            eVar.c(4, videoDetailPlayBean.getSe());
            eVar.c(5, videoDetailPlayBean.getProgress());
            if (videoDetailPlayBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, videoDetailPlayBean.getTitle());
            }
            if (videoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, videoDetailPlayBean.getCoverUrl());
            }
            if (videoDetailPlayBean.getThumbnail() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, videoDetailPlayBean.getThumbnail());
            }
            if (videoDetailPlayBean.getVideoUrl() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, videoDetailPlayBean.getVideoUrl());
            }
            eVar.c(10, videoDetailPlayBean.getTimeStamp());
            if (videoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, videoDetailPlayBean.getSubtitleSelectId());
            }
            if (videoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, videoDetailPlayBean.getTotalDuration().longValue());
            }
            if (videoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(13);
            } else {
                eVar.c(13, videoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (videoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, videoDetailPlayBean.getAverageHueLight());
            }
            if (videoDetailPlayBean.getSubjectType() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, videoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(16, videoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (videoDetailPlayBean.getPlayMode() == null) {
                eVar.g(17);
            } else {
                eVar.j(17, videoDetailPlayBean.getPlayMode());
            }
            if (videoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(18);
            } else {
                eVar.j(18, videoDetailPlayBean.getDownloadUrl());
            }
            if (videoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(19);
            } else {
                eVar.j(19, videoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(20, videoDetailPlayBean.getDownloadSize());
            String a11 = d1.this.f43194c.a(videoDetailPlayBean.getDubs());
            if (a11 == null) {
                eVar.g(21);
            } else {
                eVar.j(21, a11);
            }
            if (videoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(22);
            } else {
                eVar.c(22, videoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (videoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, videoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(24, videoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(25, videoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(26, videoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (videoDetailPlayBean.getOps() == null) {
                eVar.g(27);
            } else {
                eVar.j(27, videoDetailPlayBean.getOps());
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `video_detail_play` WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, videoDetailPlayBean.getSubjectId());
            }
            eVar.c(2, videoDetailPlayBean.getEp());
            eVar.c(3, videoDetailPlayBean.getSe());
        }
    }

    /* loaded from: classes5.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `video_detail_play` SET `subjectId` = ?,`id` = ?,`ep` = ?,`se` = ?,`progress` = ?,`title` = ?,`coverUrl` = ?,`thumbnail` = ?,`videoUrl` = ?,`timeStamp` = ?,`subtitleSelectId` = ?,`totalDuration` = ?,`subjectDurationSeconds` = ?,`averageHueLight` = ?,`subjectType` = ?,`hasDelete` = ?,`playMode` = ?,`downloadUrl` = ?,`downloadFilePath` = ?,`downloadSize` = ?,`dubs` = ?,`lastAdStartTimeStamp` = ?,`lastAdEndTimeStamp` = ?,`rewardPlayed` = ?,`rewardUnlock` = ?,`rewardFree` = ?,`ops` = ? WHERE `subjectId` = ? AND `ep` = ? AND `se` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, VideoDetailPlayBean videoDetailPlayBean) {
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, videoDetailPlayBean.getSubjectId());
            }
            if (videoDetailPlayBean.getId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, videoDetailPlayBean.getId());
            }
            eVar.c(3, videoDetailPlayBean.getEp());
            eVar.c(4, videoDetailPlayBean.getSe());
            eVar.c(5, videoDetailPlayBean.getProgress());
            if (videoDetailPlayBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, videoDetailPlayBean.getTitle());
            }
            if (videoDetailPlayBean.getCoverUrl() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, videoDetailPlayBean.getCoverUrl());
            }
            if (videoDetailPlayBean.getThumbnail() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, videoDetailPlayBean.getThumbnail());
            }
            if (videoDetailPlayBean.getVideoUrl() == null) {
                eVar.g(9);
            } else {
                eVar.j(9, videoDetailPlayBean.getVideoUrl());
            }
            eVar.c(10, videoDetailPlayBean.getTimeStamp());
            if (videoDetailPlayBean.getSubtitleSelectId() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, videoDetailPlayBean.getSubtitleSelectId());
            }
            if (videoDetailPlayBean.getTotalDuration() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, videoDetailPlayBean.getTotalDuration().longValue());
            }
            if (videoDetailPlayBean.getSubjectDurationSeconds() == null) {
                eVar.g(13);
            } else {
                eVar.c(13, videoDetailPlayBean.getSubjectDurationSeconds().longValue());
            }
            if (videoDetailPlayBean.getAverageHueLight() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, videoDetailPlayBean.getAverageHueLight());
            }
            if (videoDetailPlayBean.getSubjectType() == null) {
                eVar.g(15);
            } else {
                eVar.c(15, videoDetailPlayBean.getSubjectType().intValue());
            }
            eVar.c(16, videoDetailPlayBean.getHasDelete() ? 1L : 0L);
            if (videoDetailPlayBean.getPlayMode() == null) {
                eVar.g(17);
            } else {
                eVar.j(17, videoDetailPlayBean.getPlayMode());
            }
            if (videoDetailPlayBean.getDownloadUrl() == null) {
                eVar.g(18);
            } else {
                eVar.j(18, videoDetailPlayBean.getDownloadUrl());
            }
            if (videoDetailPlayBean.getDownloadFilePath() == null) {
                eVar.g(19);
            } else {
                eVar.j(19, videoDetailPlayBean.getDownloadFilePath());
            }
            eVar.c(20, videoDetailPlayBean.getDownloadSize());
            String a11 = d1.this.f43194c.a(videoDetailPlayBean.getDubs());
            if (a11 == null) {
                eVar.g(21);
            } else {
                eVar.j(21, a11);
            }
            if (videoDetailPlayBean.getLastAdStartTimeStamp() == null) {
                eVar.g(22);
            } else {
                eVar.c(22, videoDetailPlayBean.getLastAdStartTimeStamp().longValue());
            }
            if (videoDetailPlayBean.getLastAdEndTimeStamp() == null) {
                eVar.g(23);
            } else {
                eVar.c(23, videoDetailPlayBean.getLastAdEndTimeStamp().longValue());
            }
            eVar.c(24, videoDetailPlayBean.getRewardPlayed() ? 1L : 0L);
            eVar.c(25, videoDetailPlayBean.getRewardUnlock() ? 1L : 0L);
            eVar.c(26, videoDetailPlayBean.getRewardFree() ? 1L : 0L);
            if (videoDetailPlayBean.getOps() == null) {
                eVar.g(27);
            } else {
                eVar.j(27, videoDetailPlayBean.getOps());
            }
            if (videoDetailPlayBean.getSubjectId() == null) {
                eVar.g(28);
            } else {
                eVar.j(28, videoDetailPlayBean.getSubjectId());
            }
            eVar.c(29, videoDetailPlayBean.getEp());
            eVar.c(30, videoDetailPlayBean.getSe());
        }
    }

    public d1(RoomDatabase roomDatabase) {
        this.f43192a = roomDatabase;
    }

    public static List E() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit F(VideoDetailPlayBean videoDetailPlayBean, z3.b bVar) {
        this.f43195d.c(bVar, videoDetailPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit G(z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM VIDEO_DETAIL_PLAY");
        try {
            D0.A0();
            return Unit.f67184a;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean H(String str, z3.b bVar) {
        String n02;
        int i11;
        Integer valueOf;
        int i12;
        boolean z10;
        int i13;
        String n03;
        int i14;
        String n04;
        int i15;
        String n05;
        int i16;
        String n06;
        d1 d1Var;
        Long valueOf2;
        int i17;
        Long valueOf3;
        int i18;
        boolean z11;
        int i19;
        boolean z12;
        int i20;
        z3.e D0 = bVar.D0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d16 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = androidx.room.util.k.d(D0, "coverUrl");
            int d18 = androidx.room.util.k.d(D0, "thumbnail");
            int d19 = androidx.room.util.k.d(D0, "videoUrl");
            int d20 = androidx.room.util.k.d(D0, "timeStamp");
            int d21 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d22 = androidx.room.util.k.d(D0, "totalDuration");
            int d23 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d24 = androidx.room.util.k.d(D0, "averageHueLight");
            int d25 = androidx.room.util.k.d(D0, "subjectType");
            int d26 = androidx.room.util.k.d(D0, "hasDelete");
            int d27 = androidx.room.util.k.d(D0, "playMode");
            int d28 = androidx.room.util.k.d(D0, "downloadUrl");
            int d29 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d30 = androidx.room.util.k.d(D0, "downloadSize");
            int d31 = androidx.room.util.k.d(D0, "dubs");
            int d32 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d33 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d34 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d35 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d36 = androidx.room.util.k.d(D0, "rewardFree");
            int d37 = androidx.room.util.k.d(D0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (D0.A0()) {
                String n07 = D0.isNull(d11) ? null : D0.n0(d11);
                String n08 = D0.isNull(d12) ? null : D0.n0(d12);
                int i21 = (int) D0.getLong(d13);
                int i22 = (int) D0.getLong(d14);
                long j11 = D0.getLong(d15);
                String n09 = D0.isNull(d16) ? null : D0.n0(d16);
                String n010 = D0.isNull(d17) ? null : D0.n0(d17);
                String n011 = D0.isNull(d18) ? null : D0.n0(d18);
                String n012 = D0.isNull(d19) ? null : D0.n0(d19);
                long j12 = D0.getLong(d20);
                String n013 = D0.isNull(d21) ? null : D0.n0(d21);
                Long valueOf4 = D0.isNull(d22) ? null : Long.valueOf(D0.getLong(d22));
                Long valueOf5 = D0.isNull(d23) ? null : Long.valueOf(D0.getLong(d23));
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
                    valueOf = Integer.valueOf((int) D0.getLong(i11));
                    i12 = d26;
                }
                if (((int) D0.getLong(i12)) != 0) {
                    i13 = d27;
                    z10 = true;
                } else {
                    z10 = false;
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
                    n04 = null;
                } else {
                    n04 = D0.n0(i14);
                    i15 = d29;
                }
                if (D0.isNull(i15)) {
                    i16 = d30;
                    n05 = null;
                } else {
                    n05 = D0.n0(i15);
                    i16 = d30;
                }
                long j13 = D0.getLong(i16);
                if (D0.isNull(d31)) {
                    d1Var = this;
                    n06 = null;
                } else {
                    n06 = D0.n0(d31);
                    d1Var = this;
                }
                try {
                    ArrayList b11 = d1Var.f43194c.b(n06);
                    if (D0.isNull(d32)) {
                        i17 = d33;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(D0.getLong(d32));
                        i17 = d33;
                    }
                    if (D0.isNull(i17)) {
                        i18 = d34;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(D0.getLong(i17));
                        i18 = d34;
                    }
                    if (((int) D0.getLong(i18)) != 0) {
                        i19 = d35;
                        z11 = true;
                    } else {
                        z11 = false;
                        i19 = d35;
                    }
                    if (((int) D0.getLong(i19)) != 0) {
                        i20 = d36;
                        z12 = true;
                    } else {
                        z12 = false;
                        i20 = d36;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(n07, n08, i21, i22, j11, n09, n010, n011, n012, j12, n013, valueOf4, valueOf5, n02, valueOf, z10, n03, n04, n05, j13, b11, valueOf2, valueOf3, z11, z12, ((int) D0.getLong(i20)) != 0, D0.isNull(d37) ? null : D0.n0(d37));
                } catch (Throwable th2) {
                    th = th2;
                    D0.close();
                    throw th;
                }
            }
            D0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean I(int i11, int i12, String str, z3.b bVar) {
        String n02;
        int i13;
        Integer valueOf;
        int i14;
        int i15;
        boolean z10;
        String n03;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        d1 d1Var;
        Long valueOf2;
        int i19;
        Long valueOf3;
        int i20;
        boolean z11;
        int i21;
        boolean z12;
        int i22;
        z3.e D0 = bVar.D0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE se = ? AND ep = ? AND subjectId = ? ORDER BY timeStamp DESC LIMIT 1");
        try {
            D0.c(1, i11);
            D0.c(2, i12);
            if (str == null) {
                D0.g(3);
            } else {
                D0.j(3, str);
            }
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d16 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = androidx.room.util.k.d(D0, "coverUrl");
            int d18 = androidx.room.util.k.d(D0, "thumbnail");
            int d19 = androidx.room.util.k.d(D0, "videoUrl");
            int d20 = androidx.room.util.k.d(D0, "timeStamp");
            int d21 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d22 = androidx.room.util.k.d(D0, "totalDuration");
            int d23 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d24 = androidx.room.util.k.d(D0, "averageHueLight");
            int d25 = androidx.room.util.k.d(D0, "subjectType");
            int d26 = androidx.room.util.k.d(D0, "hasDelete");
            int d27 = androidx.room.util.k.d(D0, "playMode");
            int d28 = androidx.room.util.k.d(D0, "downloadUrl");
            int d29 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d30 = androidx.room.util.k.d(D0, "downloadSize");
            int d31 = androidx.room.util.k.d(D0, "dubs");
            int d32 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d33 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d34 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d35 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d36 = androidx.room.util.k.d(D0, "rewardFree");
            int d37 = androidx.room.util.k.d(D0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (D0.A0()) {
                String n07 = D0.isNull(d11) ? null : D0.n0(d11);
                String n08 = D0.isNull(d12) ? null : D0.n0(d12);
                int i23 = (int) D0.getLong(d13);
                int i24 = (int) D0.getLong(d14);
                long j11 = D0.getLong(d15);
                String n09 = D0.isNull(d16) ? null : D0.n0(d16);
                String n010 = D0.isNull(d17) ? null : D0.n0(d17);
                String n011 = D0.isNull(d18) ? null : D0.n0(d18);
                String n012 = D0.isNull(d19) ? null : D0.n0(d19);
                long j12 = D0.getLong(d20);
                String n013 = D0.isNull(d21) ? null : D0.n0(d21);
                Long valueOf4 = D0.isNull(d22) ? null : Long.valueOf(D0.getLong(d22));
                Long valueOf5 = D0.isNull(d23) ? null : Long.valueOf(D0.getLong(d23));
                if (D0.isNull(d24)) {
                    i13 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i13 = d25;
                }
                if (D0.isNull(i13)) {
                    i14 = d26;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) D0.getLong(i13));
                    i14 = d26;
                }
                if (((int) D0.getLong(i14)) != 0) {
                    i15 = d27;
                    z10 = true;
                } else {
                    i15 = d27;
                    z10 = false;
                }
                if (D0.isNull(i15)) {
                    i16 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i15);
                    i16 = d28;
                }
                if (D0.isNull(i16)) {
                    i17 = d29;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d29;
                }
                if (D0.isNull(i17)) {
                    i18 = d30;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d30;
                }
                long j13 = D0.getLong(i18);
                if (D0.isNull(d31)) {
                    d1Var = this;
                    n06 = null;
                } else {
                    n06 = D0.n0(d31);
                    d1Var = this;
                }
                try {
                    ArrayList b11 = d1Var.f43194c.b(n06);
                    if (D0.isNull(d32)) {
                        i19 = d33;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(D0.getLong(d32));
                        i19 = d33;
                    }
                    if (D0.isNull(i19)) {
                        i20 = d34;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(D0.getLong(i19));
                        i20 = d34;
                    }
                    if (((int) D0.getLong(i20)) != 0) {
                        i21 = d35;
                        z11 = true;
                    } else {
                        z11 = false;
                        i21 = d35;
                    }
                    if (((int) D0.getLong(i21)) != 0) {
                        i22 = d36;
                        z12 = true;
                    } else {
                        z12 = false;
                        i22 = d36;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(n07, n08, i23, i24, j11, n09, n010, n011, n012, j12, n013, valueOf4, valueOf5, n02, valueOf, z10, n03, n04, n05, j13, b11, valueOf2, valueOf3, z11, z12, ((int) D0.getLong(i22)) != 0, D0.isNull(d37) ? null : D0.n0(d37));
                } catch (Throwable th2) {
                    th = th2;
                    D0.close();
                    throw th;
                }
            }
            D0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean J(String str, int i11, int i12, z3.b bVar) {
        String n02;
        int i13;
        Integer valueOf;
        int i14;
        int i15;
        boolean z10;
        String n03;
        int i16;
        String n04;
        int i17;
        String n05;
        int i18;
        String n06;
        d1 d1Var;
        Long valueOf2;
        int i19;
        Long valueOf3;
        int i20;
        boolean z11;
        int i21;
        boolean z12;
        int i22;
        z3.e D0 = bVar.D0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? AND se = ? AND ep = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            D0.c(3, i12);
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d16 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = androidx.room.util.k.d(D0, "coverUrl");
            int d18 = androidx.room.util.k.d(D0, "thumbnail");
            int d19 = androidx.room.util.k.d(D0, "videoUrl");
            int d20 = androidx.room.util.k.d(D0, "timeStamp");
            int d21 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d22 = androidx.room.util.k.d(D0, "totalDuration");
            int d23 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d24 = androidx.room.util.k.d(D0, "averageHueLight");
            int d25 = androidx.room.util.k.d(D0, "subjectType");
            int d26 = androidx.room.util.k.d(D0, "hasDelete");
            int d27 = androidx.room.util.k.d(D0, "playMode");
            int d28 = androidx.room.util.k.d(D0, "downloadUrl");
            int d29 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d30 = androidx.room.util.k.d(D0, "downloadSize");
            int d31 = androidx.room.util.k.d(D0, "dubs");
            int d32 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d33 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d34 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d35 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d36 = androidx.room.util.k.d(D0, "rewardFree");
            int d37 = androidx.room.util.k.d(D0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (D0.A0()) {
                String n07 = D0.isNull(d11) ? null : D0.n0(d11);
                String n08 = D0.isNull(d12) ? null : D0.n0(d12);
                int i23 = (int) D0.getLong(d13);
                int i24 = (int) D0.getLong(d14);
                long j11 = D0.getLong(d15);
                String n09 = D0.isNull(d16) ? null : D0.n0(d16);
                String n010 = D0.isNull(d17) ? null : D0.n0(d17);
                String n011 = D0.isNull(d18) ? null : D0.n0(d18);
                String n012 = D0.isNull(d19) ? null : D0.n0(d19);
                long j12 = D0.getLong(d20);
                String n013 = D0.isNull(d21) ? null : D0.n0(d21);
                Long valueOf4 = D0.isNull(d22) ? null : Long.valueOf(D0.getLong(d22));
                Long valueOf5 = D0.isNull(d23) ? null : Long.valueOf(D0.getLong(d23));
                if (D0.isNull(d24)) {
                    i13 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i13 = d25;
                }
                if (D0.isNull(i13)) {
                    i14 = d26;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf((int) D0.getLong(i13));
                    i14 = d26;
                }
                if (((int) D0.getLong(i14)) != 0) {
                    i15 = d27;
                    z10 = true;
                } else {
                    i15 = d27;
                    z10 = false;
                }
                if (D0.isNull(i15)) {
                    i16 = d28;
                    n03 = null;
                } else {
                    n03 = D0.n0(i15);
                    i16 = d28;
                }
                if (D0.isNull(i16)) {
                    i17 = d29;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d29;
                }
                if (D0.isNull(i17)) {
                    i18 = d30;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d30;
                }
                long j13 = D0.getLong(i18);
                if (D0.isNull(d31)) {
                    d1Var = this;
                    n06 = null;
                } else {
                    n06 = D0.n0(d31);
                    d1Var = this;
                }
                try {
                    ArrayList b11 = d1Var.f43194c.b(n06);
                    if (D0.isNull(d32)) {
                        i19 = d33;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(D0.getLong(d32));
                        i19 = d33;
                    }
                    if (D0.isNull(i19)) {
                        i20 = d34;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(D0.getLong(i19));
                        i20 = d34;
                    }
                    if (((int) D0.getLong(i20)) != 0) {
                        i21 = d35;
                        z11 = true;
                    } else {
                        z11 = false;
                        i21 = d35;
                    }
                    if (((int) D0.getLong(i21)) != 0) {
                        i22 = d36;
                        z12 = true;
                    } else {
                        z12 = false;
                        i22 = d36;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(n07, n08, i23, i24, j11, n09, n010, n011, n012, j12, n013, valueOf4, valueOf5, n02, valueOf, z10, n03, n04, n05, j13, b11, valueOf2, valueOf3, z11, z12, ((int) D0.getLong(i22)) != 0, D0.isNull(d37) ? null : D0.n0(d37));
                } catch (Throwable th2) {
                    th = th2;
                    D0.close();
                    throw th;
                }
            }
            D0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List K(String str, z3.b bVar) {
        ArrayList arrayList;
        String n02;
        int i11;
        String n03;
        int i12;
        int i13;
        int i14;
        Integer valueOf;
        int i15;
        int i16;
        boolean z10;
        String n04;
        int i17;
        String n05;
        int i18;
        int i19;
        String n06;
        int i20;
        int i21;
        int i22;
        String n07;
        int i23;
        Long valueOf2;
        int i24;
        Long valueOf3;
        int i25;
        int i26;
        boolean z11;
        int i27;
        boolean z12;
        int i28;
        boolean z13;
        z3.e D0 = bVar.D0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE subjectId = ? ORDER BY timeStamp DESC");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d16 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = androidx.room.util.k.d(D0, "coverUrl");
            int d18 = androidx.room.util.k.d(D0, "thumbnail");
            int d19 = androidx.room.util.k.d(D0, "videoUrl");
            int d20 = androidx.room.util.k.d(D0, "timeStamp");
            int d21 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d22 = androidx.room.util.k.d(D0, "totalDuration");
            int d23 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d24 = androidx.room.util.k.d(D0, "averageHueLight");
            int d25 = androidx.room.util.k.d(D0, "subjectType");
            int d26 = androidx.room.util.k.d(D0, "hasDelete");
            int d27 = androidx.room.util.k.d(D0, "playMode");
            int d28 = androidx.room.util.k.d(D0, "downloadUrl");
            int d29 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d30 = androidx.room.util.k.d(D0, "downloadSize");
            int d31 = androidx.room.util.k.d(D0, "dubs");
            int d32 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d33 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d34 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d35 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d36 = androidx.room.util.k.d(D0, "rewardFree");
            int d37 = androidx.room.util.k.d(D0, "ops");
            ArrayList arrayList2 = new ArrayList();
            while (D0.A0()) {
                String n08 = D0.isNull(d11) ? null : D0.n0(d11);
                if (D0.isNull(d12)) {
                    arrayList = arrayList2;
                    i11 = d12;
                    n02 = null;
                } else {
                    arrayList = arrayList2;
                    n02 = D0.n0(d12);
                    i11 = d12;
                }
                int i29 = (int) D0.getLong(d13);
                int i30 = d13;
                int i31 = (int) D0.getLong(d14);
                long j11 = D0.getLong(d15);
                String n09 = D0.isNull(d16) ? null : D0.n0(d16);
                String n010 = D0.isNull(d17) ? null : D0.n0(d17);
                String n011 = D0.isNull(d18) ? null : D0.n0(d18);
                String n012 = D0.isNull(d19) ? null : D0.n0(d19);
                long j12 = D0.getLong(d20);
                String n013 = D0.isNull(d21) ? null : D0.n0(d21);
                Long valueOf4 = D0.isNull(d22) ? null : Long.valueOf(D0.getLong(d22));
                Long valueOf5 = D0.isNull(d23) ? null : Long.valueOf(D0.getLong(d23));
                if (D0.isNull(d24)) {
                    i12 = d25;
                    n03 = null;
                } else {
                    n03 = D0.n0(d24);
                    i12 = d25;
                }
                if (D0.isNull(i12)) {
                    i13 = d14;
                    i14 = d15;
                    i15 = d26;
                    valueOf = null;
                } else {
                    i13 = d14;
                    i14 = d15;
                    valueOf = Integer.valueOf((int) D0.getLong(i12));
                    i15 = d26;
                }
                int i32 = d16;
                if (((int) D0.getLong(i15)) != 0) {
                    i16 = d27;
                    z10 = true;
                } else {
                    i16 = d27;
                    z10 = false;
                }
                if (D0.isNull(i16)) {
                    i17 = d28;
                    n04 = null;
                } else {
                    n04 = D0.n0(i16);
                    i17 = d28;
                }
                if (D0.isNull(i17)) {
                    i18 = d11;
                    i19 = d29;
                    n05 = null;
                } else {
                    n05 = D0.n0(i17);
                    i18 = d11;
                    i19 = d29;
                }
                if (D0.isNull(i19)) {
                    d29 = i19;
                    i20 = d30;
                    n06 = null;
                } else {
                    n06 = D0.n0(i19);
                    d29 = i19;
                    i20 = d30;
                }
                long j13 = D0.getLong(i20);
                d30 = i20;
                int i33 = d31;
                if (D0.isNull(i33)) {
                    i21 = i33;
                    i23 = i12;
                    i22 = i15;
                    n07 = null;
                } else {
                    i21 = i33;
                    i22 = i15;
                    n07 = D0.n0(i33);
                    i23 = i12;
                }
                ArrayList b11 = this.f43194c.b(n07);
                int i34 = d32;
                if (D0.isNull(i34)) {
                    i24 = d33;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i34));
                    i24 = d33;
                }
                if (D0.isNull(i24)) {
                    d32 = i34;
                    d33 = i24;
                    i25 = d34;
                    valueOf3 = null;
                } else {
                    d33 = i24;
                    valueOf3 = Long.valueOf(D0.getLong(i24));
                    d32 = i34;
                    i25 = d34;
                }
                int i35 = i16;
                if (((int) D0.getLong(i25)) != 0) {
                    i26 = d35;
                    z11 = true;
                } else {
                    i26 = d35;
                    z11 = false;
                }
                int i36 = i17;
                if (((int) D0.getLong(i26)) != 0) {
                    i27 = d36;
                    z12 = true;
                } else {
                    i27 = d36;
                    z12 = false;
                }
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d37;
                    z13 = true;
                } else {
                    i28 = d37;
                    z13 = false;
                }
                VideoDetailPlayBean videoDetailPlayBean = new VideoDetailPlayBean(n08, n02, i29, i31, j11, n09, n010, n011, n012, j12, n013, valueOf4, valueOf5, n03, valueOf, z10, n04, n05, n06, j13, b11, valueOf2, valueOf3, z11, z12, z13, D0.isNull(i28) ? null : D0.n0(i28));
                arrayList2 = arrayList;
                arrayList2.add(videoDetailPlayBean);
                d36 = i27;
                d37 = i28;
                d16 = i32;
                d27 = i35;
                d12 = i11;
                d15 = i14;
                d26 = i22;
                d14 = i13;
                d34 = i25;
                d11 = i18;
                d25 = i23;
                d28 = i36;
                d31 = i21;
                d35 = i26;
                d13 = i30;
            }
            D0.close();
            return arrayList2;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoDetailPlayBean L(String str, z3.b bVar) {
        String n02;
        int i11;
        Integer valueOf;
        int i12;
        boolean z10;
        int i13;
        String n03;
        int i14;
        String n04;
        int i15;
        String n05;
        int i16;
        String n06;
        d1 d1Var;
        Long valueOf2;
        int i17;
        Long valueOf3;
        int i18;
        boolean z11;
        int i19;
        boolean z12;
        int i20;
        z3.e D0 = bVar.D0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE dubs LIKE '%' || ? || '%' ORDER BY timeStamp DESC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d16 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = androidx.room.util.k.d(D0, "coverUrl");
            int d18 = androidx.room.util.k.d(D0, "thumbnail");
            int d19 = androidx.room.util.k.d(D0, "videoUrl");
            int d20 = androidx.room.util.k.d(D0, "timeStamp");
            int d21 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d22 = androidx.room.util.k.d(D0, "totalDuration");
            int d23 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d24 = androidx.room.util.k.d(D0, "averageHueLight");
            int d25 = androidx.room.util.k.d(D0, "subjectType");
            int d26 = androidx.room.util.k.d(D0, "hasDelete");
            int d27 = androidx.room.util.k.d(D0, "playMode");
            int d28 = androidx.room.util.k.d(D0, "downloadUrl");
            int d29 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d30 = androidx.room.util.k.d(D0, "downloadSize");
            int d31 = androidx.room.util.k.d(D0, "dubs");
            int d32 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d33 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d34 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d35 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d36 = androidx.room.util.k.d(D0, "rewardFree");
            int d37 = androidx.room.util.k.d(D0, "ops");
            VideoDetailPlayBean videoDetailPlayBean = null;
            if (D0.A0()) {
                String n07 = D0.isNull(d11) ? null : D0.n0(d11);
                String n08 = D0.isNull(d12) ? null : D0.n0(d12);
                int i21 = (int) D0.getLong(d13);
                int i22 = (int) D0.getLong(d14);
                long j11 = D0.getLong(d15);
                String n09 = D0.isNull(d16) ? null : D0.n0(d16);
                String n010 = D0.isNull(d17) ? null : D0.n0(d17);
                String n011 = D0.isNull(d18) ? null : D0.n0(d18);
                String n012 = D0.isNull(d19) ? null : D0.n0(d19);
                long j12 = D0.getLong(d20);
                String n013 = D0.isNull(d21) ? null : D0.n0(d21);
                Long valueOf4 = D0.isNull(d22) ? null : Long.valueOf(D0.getLong(d22));
                Long valueOf5 = D0.isNull(d23) ? null : Long.valueOf(D0.getLong(d23));
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
                    valueOf = Integer.valueOf((int) D0.getLong(i11));
                    i12 = d26;
                }
                if (((int) D0.getLong(i12)) != 0) {
                    i13 = d27;
                    z10 = true;
                } else {
                    z10 = false;
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
                    n04 = null;
                } else {
                    n04 = D0.n0(i14);
                    i15 = d29;
                }
                if (D0.isNull(i15)) {
                    i16 = d30;
                    n05 = null;
                } else {
                    n05 = D0.n0(i15);
                    i16 = d30;
                }
                long j13 = D0.getLong(i16);
                if (D0.isNull(d31)) {
                    d1Var = this;
                    n06 = null;
                } else {
                    n06 = D0.n0(d31);
                    d1Var = this;
                }
                try {
                    ArrayList b11 = d1Var.f43194c.b(n06);
                    if (D0.isNull(d32)) {
                        i17 = d33;
                        valueOf2 = null;
                    } else {
                        valueOf2 = Long.valueOf(D0.getLong(d32));
                        i17 = d33;
                    }
                    if (D0.isNull(i17)) {
                        i18 = d34;
                        valueOf3 = null;
                    } else {
                        valueOf3 = Long.valueOf(D0.getLong(i17));
                        i18 = d34;
                    }
                    if (((int) D0.getLong(i18)) != 0) {
                        i19 = d35;
                        z11 = true;
                    } else {
                        z11 = false;
                        i19 = d35;
                    }
                    if (((int) D0.getLong(i19)) != 0) {
                        i20 = d36;
                        z12 = true;
                    } else {
                        z12 = false;
                        i20 = d36;
                    }
                    videoDetailPlayBean = new VideoDetailPlayBean(n07, n08, i21, i22, j11, n09, n010, n011, n012, j12, n013, valueOf4, valueOf5, n02, valueOf, z10, n03, n04, n05, j13, b11, valueOf2, valueOf3, z11, z12, ((int) D0.getLong(i20)) != 0, D0.isNull(d37) ? null : D0.n0(d37));
                } catch (Throwable th2) {
                    th = th2;
                    D0.close();
                    throw th;
                }
            }
            D0.close();
            return videoDetailPlayBean;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List M(int i11, int i12, z3.b bVar) {
        int i13;
        String n02;
        int i14;
        String n03;
        int i15;
        int i16;
        int i17;
        Integer valueOf;
        int i18;
        boolean z10;
        String n04;
        int i19;
        String n05;
        int i20;
        int i21;
        String n06;
        int i22;
        int i23;
        int i24;
        String n07;
        int i25;
        Long valueOf2;
        int i26;
        Long valueOf3;
        int i27;
        int i28;
        boolean z11;
        int i29;
        boolean z12;
        int i30;
        boolean z13;
        z3.e D0 = bVar.D0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;");
        try {
            D0.c(1, i11);
            D0.c(2, i12);
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d16 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = androidx.room.util.k.d(D0, "coverUrl");
            int d18 = androidx.room.util.k.d(D0, "thumbnail");
            int d19 = androidx.room.util.k.d(D0, "videoUrl");
            int d20 = androidx.room.util.k.d(D0, "timeStamp");
            int d21 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d22 = androidx.room.util.k.d(D0, "totalDuration");
            int d23 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d24 = androidx.room.util.k.d(D0, "averageHueLight");
            int d25 = androidx.room.util.k.d(D0, "subjectType");
            int d26 = androidx.room.util.k.d(D0, "hasDelete");
            int d27 = androidx.room.util.k.d(D0, "playMode");
            int d28 = androidx.room.util.k.d(D0, "downloadUrl");
            int d29 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d30 = androidx.room.util.k.d(D0, "downloadSize");
            int d31 = androidx.room.util.k.d(D0, "dubs");
            int d32 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d33 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d34 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d35 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d36 = androidx.room.util.k.d(D0, "rewardFree");
            int d37 = androidx.room.util.k.d(D0, "ops");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n08 = D0.isNull(d11) ? null : D0.n0(d11);
                if (D0.isNull(d12)) {
                    i14 = d11;
                    i13 = d12;
                    n02 = null;
                } else {
                    i13 = d12;
                    n02 = D0.n0(d12);
                    i14 = d11;
                }
                int i31 = (int) D0.getLong(d13);
                int i32 = d13;
                int i33 = (int) D0.getLong(d14);
                long j11 = D0.getLong(d15);
                String n09 = D0.isNull(d16) ? null : D0.n0(d16);
                String n010 = D0.isNull(d17) ? null : D0.n0(d17);
                String n011 = D0.isNull(d18) ? null : D0.n0(d18);
                String n012 = D0.isNull(d19) ? null : D0.n0(d19);
                long j12 = D0.getLong(d20);
                String n013 = D0.isNull(d21) ? null : D0.n0(d21);
                Long valueOf4 = D0.isNull(d22) ? null : Long.valueOf(D0.getLong(d22));
                Long valueOf5 = D0.isNull(d23) ? null : Long.valueOf(D0.getLong(d23));
                if (D0.isNull(d24)) {
                    i15 = d25;
                    n03 = null;
                } else {
                    n03 = D0.n0(d24);
                    i15 = d25;
                }
                if (D0.isNull(i15)) {
                    i16 = d14;
                    i17 = d15;
                    valueOf = null;
                } else {
                    i16 = d14;
                    i17 = d15;
                    valueOf = Integer.valueOf((int) D0.getLong(i15));
                }
                int i34 = d26;
                int i35 = d16;
                if (((int) D0.getLong(i34)) != 0) {
                    i18 = d27;
                    z10 = true;
                } else {
                    i18 = d27;
                    z10 = false;
                }
                if (D0.isNull(i18)) {
                    i19 = d28;
                    n04 = null;
                } else {
                    n04 = D0.n0(i18);
                    i19 = d28;
                }
                if (D0.isNull(i19)) {
                    i20 = i15;
                    i21 = d29;
                    n05 = null;
                } else {
                    n05 = D0.n0(i19);
                    i20 = i15;
                    i21 = d29;
                }
                if (D0.isNull(i21)) {
                    d29 = i21;
                    i22 = d30;
                    n06 = null;
                } else {
                    n06 = D0.n0(i21);
                    d29 = i21;
                    i22 = d30;
                }
                long j13 = D0.getLong(i22);
                d30 = i22;
                int i36 = d31;
                if (D0.isNull(i36)) {
                    i23 = i36;
                    i25 = i34;
                    i24 = i18;
                    n07 = null;
                } else {
                    i23 = i36;
                    i24 = i18;
                    n07 = D0.n0(i36);
                    i25 = i34;
                }
                ArrayList b11 = this.f43194c.b(n07);
                int i37 = d32;
                if (D0.isNull(i37)) {
                    i26 = d33;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i37));
                    i26 = d33;
                }
                if (D0.isNull(i26)) {
                    d32 = i37;
                    d33 = i26;
                    i27 = d34;
                    valueOf3 = null;
                } else {
                    d33 = i26;
                    valueOf3 = Long.valueOf(D0.getLong(i26));
                    d32 = i37;
                    i27 = d34;
                }
                int i38 = i19;
                if (((int) D0.getLong(i27)) != 0) {
                    i28 = d35;
                    z11 = true;
                } else {
                    i28 = d35;
                    z11 = false;
                }
                int i39 = i27;
                d35 = i28;
                if (((int) D0.getLong(i28)) != 0) {
                    i29 = d36;
                    z12 = true;
                } else {
                    i29 = d36;
                    z12 = false;
                }
                if (((int) D0.getLong(i29)) != 0) {
                    i30 = d37;
                    z13 = true;
                } else {
                    i30 = d37;
                    z13 = false;
                }
                arrayList.add(new VideoDetailPlayBean(n08, n02, i31, i33, j11, n09, n010, n011, n012, j12, n013, valueOf4, valueOf5, n03, valueOf, z10, n04, n05, n06, j13, b11, valueOf2, valueOf3, z11, z12, z13, D0.isNull(i30) ? null : D0.n0(i30)));
                d14 = i16;
                d37 = i30;
                d36 = i29;
                d25 = i20;
                d28 = i38;
                d11 = i14;
                d12 = i13;
                d13 = i32;
                d15 = i17;
                d27 = i24;
                d34 = i39;
                d16 = i35;
                d26 = i25;
                d31 = i23;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long N(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT SUM(progress) AS totalProgress FROM VIDEO_DETAIL_PLAY WHERE subjectId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            Long l11 = null;
            if (D0.A0() && !D0.isNull(0)) {
                l11 = Long.valueOf(D0.getLong(0));
            }
            return l11;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List O(int i11, int i12, int i13, z3.b bVar) {
        int i14;
        String n02;
        int i15;
        String n03;
        int i16;
        int i17;
        int i18;
        Integer valueOf;
        int i19;
        boolean z10;
        int i20;
        String n04;
        String n05;
        int i21;
        int i22;
        String n06;
        int i23;
        int i24;
        int i25;
        String n07;
        int i26;
        Long valueOf2;
        int i27;
        Long valueOf3;
        int i28;
        int i29;
        boolean z11;
        int i30;
        boolean z12;
        int i31;
        boolean z13;
        z3.e D0 = bVar.D0("SELECT * FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL AND subjectType=? AND subjectDurationSeconds > 0 AND rowid IN (SELECT rowid FROM (SELECT rowid, subjectId, MAX(timeStamp) as maxTimeStamp FROM VIDEO_DETAIL_PLAY WHERE coverUrl IS NOT NULL GROUP BY subjectId)) ORDER BY timeStamp DESC LIMIT ? OFFSET ?;");
        try {
            D0.c(1, i11);
            D0.c(2, i12);
            D0.c(3, i13);
            int d11 = androidx.room.util.k.d(D0, "subjectId");
            int d12 = androidx.room.util.k.d(D0, "id");
            int d13 = androidx.room.util.k.d(D0, "ep");
            int d14 = androidx.room.util.k.d(D0, "se");
            int d15 = androidx.room.util.k.d(D0, NotificationCompat.CATEGORY_PROGRESS);
            int d16 = androidx.room.util.k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = androidx.room.util.k.d(D0, "coverUrl");
            int d18 = androidx.room.util.k.d(D0, "thumbnail");
            int d19 = androidx.room.util.k.d(D0, "videoUrl");
            int d20 = androidx.room.util.k.d(D0, "timeStamp");
            int d21 = androidx.room.util.k.d(D0, "subtitleSelectId");
            int d22 = androidx.room.util.k.d(D0, "totalDuration");
            int d23 = androidx.room.util.k.d(D0, "subjectDurationSeconds");
            int d24 = androidx.room.util.k.d(D0, "averageHueLight");
            int d25 = androidx.room.util.k.d(D0, "subjectType");
            int d26 = androidx.room.util.k.d(D0, "hasDelete");
            int d27 = androidx.room.util.k.d(D0, "playMode");
            int d28 = androidx.room.util.k.d(D0, "downloadUrl");
            int d29 = androidx.room.util.k.d(D0, "downloadFilePath");
            int d30 = androidx.room.util.k.d(D0, "downloadSize");
            int d31 = androidx.room.util.k.d(D0, "dubs");
            int d32 = androidx.room.util.k.d(D0, "lastAdStartTimeStamp");
            int d33 = androidx.room.util.k.d(D0, "lastAdEndTimeStamp");
            int d34 = androidx.room.util.k.d(D0, "rewardPlayed");
            int d35 = androidx.room.util.k.d(D0, "rewardUnlock");
            int d36 = androidx.room.util.k.d(D0, "rewardFree");
            int d37 = androidx.room.util.k.d(D0, "ops");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n08 = D0.isNull(d11) ? null : D0.n0(d11);
                if (D0.isNull(d12)) {
                    i15 = d11;
                    i14 = d12;
                    n02 = null;
                } else {
                    i14 = d12;
                    n02 = D0.n0(d12);
                    i15 = d11;
                }
                int i32 = (int) D0.getLong(d13);
                int i33 = d13;
                int i34 = (int) D0.getLong(d14);
                long j11 = D0.getLong(d15);
                String n09 = D0.isNull(d16) ? null : D0.n0(d16);
                String n010 = D0.isNull(d17) ? null : D0.n0(d17);
                String n011 = D0.isNull(d18) ? null : D0.n0(d18);
                String n012 = D0.isNull(d19) ? null : D0.n0(d19);
                long j12 = D0.getLong(d20);
                String n013 = D0.isNull(d21) ? null : D0.n0(d21);
                Long valueOf4 = D0.isNull(d22) ? null : Long.valueOf(D0.getLong(d22));
                Long valueOf5 = D0.isNull(d23) ? null : Long.valueOf(D0.getLong(d23));
                if (D0.isNull(d24)) {
                    i16 = d25;
                    n03 = null;
                } else {
                    n03 = D0.n0(d24);
                    i16 = d25;
                }
                if (D0.isNull(i16)) {
                    i17 = d14;
                    i18 = d15;
                    valueOf = null;
                } else {
                    i17 = d14;
                    i18 = d15;
                    valueOf = Integer.valueOf((int) D0.getLong(i16));
                }
                int i35 = d26;
                int i36 = d16;
                if (((int) D0.getLong(i35)) != 0) {
                    i19 = d27;
                    z10 = true;
                } else {
                    i19 = d27;
                    z10 = false;
                }
                if (D0.isNull(i19)) {
                    i20 = d28;
                    n04 = null;
                } else {
                    i20 = d28;
                    n04 = D0.n0(i19);
                }
                if (D0.isNull(i20)) {
                    i21 = i16;
                    i22 = d29;
                    n05 = null;
                } else {
                    n05 = D0.n0(i20);
                    i21 = i16;
                    i22 = d29;
                }
                if (D0.isNull(i22)) {
                    d29 = i22;
                    i23 = d30;
                    n06 = null;
                } else {
                    n06 = D0.n0(i22);
                    d29 = i22;
                    i23 = d30;
                }
                long j13 = D0.getLong(i23);
                d30 = i23;
                int i37 = d31;
                if (D0.isNull(i37)) {
                    i24 = i37;
                    i26 = i35;
                    i25 = i19;
                    n07 = null;
                } else {
                    i24 = i37;
                    i25 = i19;
                    n07 = D0.n0(i37);
                    i26 = i35;
                }
                ArrayList b11 = this.f43194c.b(n07);
                int i38 = d32;
                if (D0.isNull(i38)) {
                    i27 = d33;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(D0.getLong(i38));
                    i27 = d33;
                }
                if (D0.isNull(i27)) {
                    d32 = i38;
                    d33 = i27;
                    i28 = d34;
                    valueOf3 = null;
                } else {
                    d33 = i27;
                    valueOf3 = Long.valueOf(D0.getLong(i27));
                    d32 = i38;
                    i28 = d34;
                }
                int i39 = i20;
                if (((int) D0.getLong(i28)) != 0) {
                    i29 = d35;
                    z11 = true;
                } else {
                    i29 = d35;
                    z11 = false;
                }
                int i40 = i28;
                d35 = i29;
                if (((int) D0.getLong(i29)) != 0) {
                    i30 = d36;
                    z12 = true;
                } else {
                    i30 = d36;
                    z12 = false;
                }
                if (((int) D0.getLong(i30)) != 0) {
                    i31 = d37;
                    z13 = true;
                } else {
                    i31 = d37;
                    z13 = false;
                }
                arrayList.add(new VideoDetailPlayBean(n08, n02, i32, i34, j11, n09, n010, n011, n012, j12, n013, valueOf4, valueOf5, n03, valueOf, z10, n04, n05, n06, j13, b11, valueOf2, valueOf3, z11, z12, z13, D0.isNull(i31) ? null : D0.n0(i31)));
                d14 = i17;
                d37 = i31;
                d36 = i30;
                d25 = i21;
                d28 = i39;
                d11 = i15;
                d12 = i14;
                d13 = i33;
                d15 = i18;
                d27 = i25;
                d34 = i40;
                d16 = i36;
                d26 = i26;
                d31 = i24;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit P(VideoDetailPlayBean videoDetailPlayBean, z3.b bVar) {
        this.f43193b.d(bVar, videoDetailPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Q(VideoDetailPlayBean videoDetailPlayBean, z3.b bVar) {
        this.f43196e.c(bVar, videoDetailPlayBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit R(String str, String str2, z3.b bVar) {
        z3.e D0 = bVar.D0("UPDATE VIDEO_DETAIL_PLAY SET subtitleSelectId = ? WHERE subjectId = ? ");
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

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G;
                G = d1.G((z3.b) obj);
                return G;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object b(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R;
                R = d1.R(str2, str, (z3.b) obj);
                return R;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object c(String str, Continuation continuation) {
        return VideoDetailPlayDao.DefaultImpls.a(this, str, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object d(final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List M;
                M = d1.this.M(i12, i11, (z3.b) obj);
                return M;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                VideoDetailPlayBean H;
                H = d1.this.H(str, (z3.b) obj);
                return H;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object f(String str, int i11, int i12, long j11, long j12, Continuation continuation) {
        return VideoDetailPlayDao.DefaultImpls.c(this, str, i11, i12, j11, j12, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Long N;
                N = d1.N(str, (z3.b) obj);
                return N;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object h(final VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        videoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.f43192a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = d1.this.F(videoDetailPlayBean, (z3.b) obj);
                return F;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object i(final int i11, final int i12, final int i13, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List O;
                O = d1.this.O(i13, i12, i11, (z3.b) obj);
                return O;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object j(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List K;
                K = d1.this.K(str, (z3.b) obj);
                return K;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object k(final VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        videoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.f43192a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q;
                Q = d1.this.Q(videoDetailPlayBean, (z3.b) obj);
                return Q;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object l(final String str, final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                VideoDetailPlayBean I;
                I = d1.this.I(i11, i12, str, (z3.b) obj);
                return I;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object m(final String str, final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                VideoDetailPlayBean J;
                J = d1.this.J(str, i11, i12, (z3.b) obj);
                return J;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object n(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f43192a, true, false, new Function1() { // from class: com.transsion.baselib.db.video.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                VideoDetailPlayBean L;
                L = d1.this.L(str, (z3.b) obj);
                return L;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object o(final VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        videoDetailPlayBean.getClass();
        return androidx.room.util.b.f(this.f43192a, false, true, new Function1() { // from class: com.transsion.baselib.db.video.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P;
                P = d1.this.P(videoDetailPlayBean, (z3.b) obj);
                return P;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.video.VideoDetailPlayDao
    public Object p(VideoDetailPlayBean videoDetailPlayBean, Continuation continuation) {
        return VideoDetailPlayDao.DefaultImpls.b(this, videoDetailPlayBean, continuation);
    }
}

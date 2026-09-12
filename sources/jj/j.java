package jj;

import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import androidx.room.util.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.db.audio.AudioBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class j implements jj.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f66336a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f66337b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f66338c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.e f66339d = new c();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `audio` (`audioId`,`cover`,`duration`,`size`,`url`,`title`,`desc`,`bitrate`,`updateTimeStamp`,`readProcess`,`localPath`,`ops`,`resourceId`,`postId`,`subjectId`,`groupId`,`status`,`subjectTitle`,`se`,`ep`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, audioBean.getAudioUrl());
            }
            if (audioBean.getCover() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, audioBean.getCover());
            }
            if (audioBean.getDuration() == null) {
                eVar.g(3);
            } else {
                eVar.c(3, audioBean.getDuration().longValue());
            }
            if (audioBean.getSize() == null) {
                eVar.g(4);
            } else {
                eVar.c(4, audioBean.getSize().longValue());
            }
            if (audioBean.getUrl() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, audioBean.getUrl());
            }
            if (audioBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, audioBean.getTitle());
            }
            if (audioBean.getDesc() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, audioBean.getDesc());
            }
            if (audioBean.getBitrate() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, audioBean.getBitrate().intValue());
            }
            if (audioBean.getUpdateTimeStamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, audioBean.getUpdateTimeStamp().longValue());
            }
            if (audioBean.getReadProcess() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, audioBean.getReadProcess().longValue());
            }
            if (audioBean.getLocalPath() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, audioBean.getLocalPath());
            }
            if (audioBean.getOps() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, audioBean.getOps());
            }
            if (audioBean.getResourceId() == null) {
                eVar.g(13);
            } else {
                eVar.j(13, audioBean.getResourceId());
            }
            if (audioBean.getPostId() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, audioBean.getPostId());
            }
            if (audioBean.getSubjectId() == null) {
                eVar.g(15);
            } else {
                eVar.j(15, audioBean.getSubjectId());
            }
            if (audioBean.getGroupId() == null) {
                eVar.g(16);
            } else {
                eVar.j(16, audioBean.getGroupId());
            }
            eVar.c(17, audioBean.getStatus());
            if (audioBean.getSubjectTitle() == null) {
                eVar.g(18);
            } else {
                eVar.j(18, audioBean.getSubjectTitle());
            }
            eVar.c(19, audioBean.getSe());
            eVar.c(20, audioBean.getEp());
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `audio` WHERE `audioId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, audioBean.getAudioUrl());
            }
        }
    }

    /* loaded from: classes6.dex */
    class c extends androidx.room.e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `audio` SET `audioId` = ?,`cover` = ?,`duration` = ?,`size` = ?,`url` = ?,`title` = ?,`desc` = ?,`bitrate` = ?,`updateTimeStamp` = ?,`readProcess` = ?,`localPath` = ?,`ops` = ?,`resourceId` = ?,`postId` = ?,`subjectId` = ?,`groupId` = ?,`status` = ?,`subjectTitle` = ?,`se` = ?,`ep` = ? WHERE `audioId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AudioBean audioBean) {
            if (audioBean.getAudioUrl() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, audioBean.getAudioUrl());
            }
            if (audioBean.getCover() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, audioBean.getCover());
            }
            if (audioBean.getDuration() == null) {
                eVar.g(3);
            } else {
                eVar.c(3, audioBean.getDuration().longValue());
            }
            if (audioBean.getSize() == null) {
                eVar.g(4);
            } else {
                eVar.c(4, audioBean.getSize().longValue());
            }
            if (audioBean.getUrl() == null) {
                eVar.g(5);
            } else {
                eVar.j(5, audioBean.getUrl());
            }
            if (audioBean.getTitle() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, audioBean.getTitle());
            }
            if (audioBean.getDesc() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, audioBean.getDesc());
            }
            if (audioBean.getBitrate() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, audioBean.getBitrate().intValue());
            }
            if (audioBean.getUpdateTimeStamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, audioBean.getUpdateTimeStamp().longValue());
            }
            if (audioBean.getReadProcess() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, audioBean.getReadProcess().longValue());
            }
            if (audioBean.getLocalPath() == null) {
                eVar.g(11);
            } else {
                eVar.j(11, audioBean.getLocalPath());
            }
            if (audioBean.getOps() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, audioBean.getOps());
            }
            if (audioBean.getResourceId() == null) {
                eVar.g(13);
            } else {
                eVar.j(13, audioBean.getResourceId());
            }
            if (audioBean.getPostId() == null) {
                eVar.g(14);
            } else {
                eVar.j(14, audioBean.getPostId());
            }
            if (audioBean.getSubjectId() == null) {
                eVar.g(15);
            } else {
                eVar.j(15, audioBean.getSubjectId());
            }
            if (audioBean.getGroupId() == null) {
                eVar.g(16);
            } else {
                eVar.j(16, audioBean.getGroupId());
            }
            eVar.c(17, audioBean.getStatus());
            if (audioBean.getSubjectTitle() == null) {
                eVar.g(18);
            } else {
                eVar.j(18, audioBean.getSubjectTitle());
            }
            eVar.c(19, audioBean.getSe());
            eVar.c(20, audioBean.getEp());
            if (audioBean.getAudioUrl() == null) {
                eVar.g(21);
            } else {
                eVar.j(21, audioBean.getAudioUrl());
            }
        }
    }

    public j(RoomDatabase roomDatabase) {
        this.f66336a = roomDatabase;
    }

    public static List q() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit r(z3.b bVar) {
        z3.e D0 = bVar.D0("DELETE FROM Audio");
        try {
            D0.A0();
            return Unit.f67184a;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(AudioBean audioBean, z3.b bVar) {
        this.f66338c.c(bVar, audioBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioBean t(String str, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        z3.e D0 = bVar.D0("SELECT * FROM Audio WHERE audioId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "audioId");
            int d12 = k.d(D0, "cover");
            int d13 = k.d(D0, "duration");
            int d14 = k.d(D0, "size");
            int d15 = k.d(D0, "url");
            int d16 = k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = k.d(D0, CampaignEx.JSON_KEY_DESC);
            int d18 = k.d(D0, "bitrate");
            int d19 = k.d(D0, "updateTimeStamp");
            int d20 = k.d(D0, "readProcess");
            int d21 = k.d(D0, "localPath");
            int d22 = k.d(D0, "ops");
            int d23 = k.d(D0, "resourceId");
            int d24 = k.d(D0, "postId");
            int d25 = k.d(D0, "subjectId");
            int d26 = k.d(D0, "groupId");
            int d27 = k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d28 = k.d(D0, "subjectTitle");
            int d29 = k.d(D0, "se");
            int d30 = k.d(D0, "ep");
            AudioBean audioBean = null;
            if (D0.A0()) {
                String n05 = D0.isNull(d11) ? null : D0.n0(d11);
                String n06 = D0.isNull(d12) ? null : D0.n0(d12);
                Long valueOf = D0.isNull(d13) ? null : Long.valueOf(D0.getLong(d13));
                Long valueOf2 = D0.isNull(d14) ? null : Long.valueOf(D0.getLong(d14));
                String n07 = D0.isNull(d15) ? null : D0.n0(d15);
                String n08 = D0.isNull(d16) ? null : D0.n0(d16);
                String n09 = D0.isNull(d17) ? null : D0.n0(d17);
                Integer valueOf3 = D0.isNull(d18) ? null : Integer.valueOf((int) D0.getLong(d18));
                Long valueOf4 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf5 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                String n010 = D0.isNull(d21) ? null : D0.n0(d21);
                String n011 = D0.isNull(d22) ? null : D0.n0(d22);
                String n012 = D0.isNull(d23) ? null : D0.n0(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d27;
                }
                audioBean = new AudioBean(n05, n06, valueOf, valueOf2, n07, n08, n09, valueOf3, valueOf4, valueOf5, n010, n011, n012, n02, n03, n04, (int) D0.getLong(i13), D0.isNull(d28) ? null : D0.n0(d28), (int) D0.getLong(d29), (int) D0.getLong(d30));
            }
            D0.close();
            return audioBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioBean u(String str, String str2, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        z3.e D0 = bVar.D0("SELECT * FROM Audio WHERE postId = ? AND subjectId =?");
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
            int d11 = k.d(D0, "audioId");
            int d12 = k.d(D0, "cover");
            int d13 = k.d(D0, "duration");
            int d14 = k.d(D0, "size");
            int d15 = k.d(D0, "url");
            int d16 = k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = k.d(D0, CampaignEx.JSON_KEY_DESC);
            int d18 = k.d(D0, "bitrate");
            int d19 = k.d(D0, "updateTimeStamp");
            int d20 = k.d(D0, "readProcess");
            int d21 = k.d(D0, "localPath");
            int d22 = k.d(D0, "ops");
            int d23 = k.d(D0, "resourceId");
            int d24 = k.d(D0, "postId");
            int d25 = k.d(D0, "subjectId");
            int d26 = k.d(D0, "groupId");
            int d27 = k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d28 = k.d(D0, "subjectTitle");
            int d29 = k.d(D0, "se");
            int d30 = k.d(D0, "ep");
            AudioBean audioBean = null;
            if (D0.A0()) {
                String n05 = D0.isNull(d11) ? null : D0.n0(d11);
                String n06 = D0.isNull(d12) ? null : D0.n0(d12);
                Long valueOf = D0.isNull(d13) ? null : Long.valueOf(D0.getLong(d13));
                Long valueOf2 = D0.isNull(d14) ? null : Long.valueOf(D0.getLong(d14));
                String n07 = D0.isNull(d15) ? null : D0.n0(d15);
                String n08 = D0.isNull(d16) ? null : D0.n0(d16);
                String n09 = D0.isNull(d17) ? null : D0.n0(d17);
                Integer valueOf3 = D0.isNull(d18) ? null : Integer.valueOf((int) D0.getLong(d18));
                Long valueOf4 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf5 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                String n010 = D0.isNull(d21) ? null : D0.n0(d21);
                String n011 = D0.isNull(d22) ? null : D0.n0(d22);
                String n012 = D0.isNull(d23) ? null : D0.n0(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d27;
                }
                audioBean = new AudioBean(n05, n06, valueOf, valueOf2, n07, n08, n09, valueOf3, valueOf4, valueOf5, n010, n011, n012, n02, n03, n04, (int) D0.getLong(i13), D0.isNull(d28) ? null : D0.n0(d28), (int) D0.getLong(d29), (int) D0.getLong(d30));
            }
            D0.close();
            return audioBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioBean v(String str, z3.b bVar) {
        String n02;
        int i11;
        String n03;
        int i12;
        String n04;
        int i13;
        z3.e D0 = bVar.D0("SELECT * FROM Audio WHERE resourceId = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = k.d(D0, "audioId");
            int d12 = k.d(D0, "cover");
            int d13 = k.d(D0, "duration");
            int d14 = k.d(D0, "size");
            int d15 = k.d(D0, "url");
            int d16 = k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = k.d(D0, CampaignEx.JSON_KEY_DESC);
            int d18 = k.d(D0, "bitrate");
            int d19 = k.d(D0, "updateTimeStamp");
            int d20 = k.d(D0, "readProcess");
            int d21 = k.d(D0, "localPath");
            int d22 = k.d(D0, "ops");
            int d23 = k.d(D0, "resourceId");
            int d24 = k.d(D0, "postId");
            int d25 = k.d(D0, "subjectId");
            int d26 = k.d(D0, "groupId");
            int d27 = k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d28 = k.d(D0, "subjectTitle");
            int d29 = k.d(D0, "se");
            int d30 = k.d(D0, "ep");
            AudioBean audioBean = null;
            if (D0.A0()) {
                String n05 = D0.isNull(d11) ? null : D0.n0(d11);
                String n06 = D0.isNull(d12) ? null : D0.n0(d12);
                Long valueOf = D0.isNull(d13) ? null : Long.valueOf(D0.getLong(d13));
                Long valueOf2 = D0.isNull(d14) ? null : Long.valueOf(D0.getLong(d14));
                String n07 = D0.isNull(d15) ? null : D0.n0(d15);
                String n08 = D0.isNull(d16) ? null : D0.n0(d16);
                String n09 = D0.isNull(d17) ? null : D0.n0(d17);
                Integer valueOf3 = D0.isNull(d18) ? null : Integer.valueOf((int) D0.getLong(d18));
                Long valueOf4 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf5 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                String n010 = D0.isNull(d21) ? null : D0.n0(d21);
                String n011 = D0.isNull(d22) ? null : D0.n0(d22);
                String n012 = D0.isNull(d23) ? null : D0.n0(d23);
                if (D0.isNull(d24)) {
                    i11 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i11 = d25;
                }
                if (D0.isNull(i11)) {
                    i12 = d26;
                    n03 = null;
                } else {
                    n03 = D0.n0(i11);
                    i12 = d26;
                }
                if (D0.isNull(i12)) {
                    i13 = d27;
                    n04 = null;
                } else {
                    n04 = D0.n0(i12);
                    i13 = d27;
                }
                audioBean = new AudioBean(n05, n06, valueOf, valueOf2, n07, n08, n09, valueOf3, valueOf4, valueOf5, n010, n011, n012, n02, n03, n04, (int) D0.getLong(i13), D0.isNull(d28) ? null : D0.n0(d28), (int) D0.getLong(d29), (int) D0.getLong(d30));
            }
            D0.close();
            return audioBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List w(z3.b bVar) {
        int i11;
        int i12;
        Integer valueOf;
        String n02;
        int i13;
        String n03;
        int i14;
        int i15;
        String n04;
        int i16;
        int i17;
        z3.e D0 = bVar.D0("SELECT * FROM Audio ORDER BY updateTimeStamp DESC");
        try {
            int d11 = k.d(D0, "audioId");
            int d12 = k.d(D0, "cover");
            int d13 = k.d(D0, "duration");
            int d14 = k.d(D0, "size");
            int d15 = k.d(D0, "url");
            int d16 = k.d(D0, CampaignEx.JSON_KEY_TITLE);
            int d17 = k.d(D0, CampaignEx.JSON_KEY_DESC);
            int d18 = k.d(D0, "bitrate");
            int d19 = k.d(D0, "updateTimeStamp");
            int d20 = k.d(D0, "readProcess");
            int d21 = k.d(D0, "localPath");
            int d22 = k.d(D0, "ops");
            int d23 = k.d(D0, "resourceId");
            int d24 = k.d(D0, "postId");
            int d25 = k.d(D0, "subjectId");
            int d26 = k.d(D0, "groupId");
            int d27 = k.d(D0, NotificationCompat.CATEGORY_STATUS);
            int d28 = k.d(D0, "subjectTitle");
            int d29 = k.d(D0, "se");
            int d30 = k.d(D0, "ep");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                String n05 = D0.isNull(d11) ? null : D0.n0(d11);
                String n06 = D0.isNull(d12) ? null : D0.n0(d12);
                Long valueOf2 = D0.isNull(d13) ? null : Long.valueOf(D0.getLong(d13));
                Long valueOf3 = D0.isNull(d14) ? null : Long.valueOf(D0.getLong(d14));
                String n07 = D0.isNull(d15) ? null : D0.n0(d15);
                String n08 = D0.isNull(d16) ? null : D0.n0(d16);
                String n09 = D0.isNull(d17) ? null : D0.n0(d17);
                if (D0.isNull(d18)) {
                    i11 = d12;
                    i12 = d13;
                    valueOf = null;
                } else {
                    i11 = d12;
                    i12 = d13;
                    valueOf = Integer.valueOf((int) D0.getLong(d18));
                }
                Long valueOf4 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                Long valueOf5 = D0.isNull(d20) ? null : Long.valueOf(D0.getLong(d20));
                String n010 = D0.isNull(d21) ? null : D0.n0(d21);
                String n011 = D0.isNull(d22) ? null : D0.n0(d22);
                String n012 = D0.isNull(d23) ? null : D0.n0(d23);
                if (D0.isNull(d24)) {
                    i13 = d25;
                    n02 = null;
                } else {
                    n02 = D0.n0(d24);
                    i13 = d25;
                }
                if (D0.isNull(i13)) {
                    i14 = d26;
                    n03 = null;
                } else {
                    n03 = D0.n0(i13);
                    i14 = d26;
                }
                if (D0.isNull(i14)) {
                    i15 = d11;
                    i17 = i13;
                    i16 = d27;
                    n04 = null;
                } else {
                    i15 = d11;
                    n04 = D0.n0(i14);
                    i16 = d27;
                    i17 = i13;
                }
                int i18 = i14;
                int i19 = (int) D0.getLong(i16);
                int i20 = d28;
                int i21 = i16;
                int i22 = d29;
                int i23 = d14;
                int i24 = d16;
                int i25 = d30;
                int i26 = d15;
                arrayList.add(new AudioBean(n05, n06, valueOf2, valueOf3, n07, n08, n09, valueOf, valueOf4, valueOf5, n010, n011, n012, n02, n03, n04, i19, D0.isNull(i20) ? null : D0.n0(i20), (int) D0.getLong(i22), (int) D0.getLong(i25)));
                d15 = i26;
                d12 = i11;
                d13 = i12;
                d16 = i24;
                d30 = i25;
                d14 = i23;
                d29 = i22;
                d11 = i15;
                d25 = i17;
                d26 = i18;
                d27 = i21;
                d28 = i20;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit x(AudioBean audioBean, z3.b bVar) {
        this.f66337b.d(bVar, audioBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit y(AudioBean audioBean, z3.b bVar) {
        this.f66339d.c(bVar, audioBean);
        return Unit.f67184a;
    }

    @Override // jj.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f66336a, false, true, new Function1() { // from class: jj.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r11;
                r11 = j.r((z3.b) obj);
                return r11;
            }
        }, continuation);
    }

    @Override // jj.a
    public Object b(final AudioBean audioBean, Continuation continuation) {
        audioBean.getClass();
        return androidx.room.util.b.f(this.f66336a, false, true, new Function1() { // from class: jj.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s11;
                s11 = j.this.s(audioBean, (z3.b) obj);
                return s11;
            }
        }, continuation);
    }

    @Override // jj.a
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f66336a, true, false, new Function1() { // from class: jj.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                AudioBean t11;
                t11 = j.t(str, (z3.b) obj);
                return t11;
            }
        }, continuation);
    }

    @Override // jj.a
    public Object d(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f66336a, true, false, new Function1() { // from class: jj.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                AudioBean v11;
                v11 = j.v(str, (z3.b) obj);
                return v11;
            }
        }, continuation);
    }

    @Override // jj.a
    public Object e(Continuation continuation) {
        return androidx.room.util.b.f(this.f66336a, true, false, new Function1() { // from class: jj.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List w11;
                w11 = j.w((z3.b) obj);
                return w11;
            }
        }, continuation);
    }

    @Override // jj.a
    public Object f(final AudioBean audioBean, Continuation continuation) {
        audioBean.getClass();
        return androidx.room.util.b.f(this.f66336a, false, true, new Function1() { // from class: jj.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y10;
                y10 = j.this.y(audioBean, (z3.b) obj);
                return y10;
            }
        }, continuation);
    }

    @Override // jj.a
    public Object g(final String str, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f66336a, true, false, new Function1() { // from class: jj.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                AudioBean u11;
                u11 = j.u(str, str2, (z3.b) obj);
                return u11;
            }
        }, continuation);
    }

    @Override // jj.a
    public Object h(final AudioBean audioBean, Continuation continuation) {
        audioBean.getClass();
        return androidx.room.util.b.f(this.f66336a, false, true, new Function1() { // from class: jj.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x10;
                x10 = j.this.x(audioBean, (z3.b) obj);
                return x10;
            }
        }, continuation);
    }
}

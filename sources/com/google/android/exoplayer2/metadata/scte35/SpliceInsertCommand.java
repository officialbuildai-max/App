package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<b> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand[] newArray(int i11) {
            return new SpliceInsertCommand[i11];
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f25495a;

        /* renamed from: b, reason: collision with root package name */
        public final long f25496b;

        /* renamed from: c, reason: collision with root package name */
        public final long f25497c;

        private b(int i11, long j11, long j12) {
            this.f25495a = i11;
            this.f25496b = j11;
            this.f25497c = j12;
        }

        /* synthetic */ b(int i11, long j11, long j12, a aVar) {
            this(i11, j11, j12);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f25495a);
            parcel.writeLong(this.f25496b);
            parcel.writeLong(this.f25497c);
        }
    }

    private SpliceInsertCommand(long j11, boolean z10, boolean z11, boolean z12, boolean z13, long j12, long j13, List<b> list, boolean z14, long j14, int i11, int i12, int i13) {
        this.spliceEventId = j11;
        this.spliceEventCancelIndicator = z10;
        this.outOfNetworkIndicator = z11;
        this.programSpliceFlag = z12;
        this.spliceImmediateFlag = z13;
        this.programSplicePts = j12;
        this.programSplicePlaybackPositionUs = j13;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z14;
        this.breakDurationUs = j14;
        this.uniqueProgramId = i11;
        this.availNum = i12;
        this.availsExpected = i13;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList.add(b.a(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }

    /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceInsertCommand parseFromSection(d0 d0Var, long j11, l0 l0Var) {
        List list;
        boolean z10;
        boolean z11;
        long j12;
        boolean z12;
        long j13;
        int i11;
        int i12;
        int i13;
        boolean z13;
        boolean z14;
        long j14;
        long F = d0Var.F();
        boolean z15 = (d0Var.D() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z15) {
            list = emptyList;
            z10 = false;
            z11 = false;
            j12 = C.TIME_UNSET;
            z12 = false;
            j13 = C.TIME_UNSET;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            z13 = false;
        } else {
            int D = d0Var.D();
            boolean z16 = (D & 128) != 0;
            boolean z17 = (D & 64) != 0;
            boolean z18 = (D & 32) != 0;
            boolean z19 = (D & 16) != 0;
            long parseSpliceTime = (!z17 || z19) ? C.TIME_UNSET : TimeSignalCommand.parseSpliceTime(d0Var, j11);
            if (!z17) {
                int D2 = d0Var.D();
                ArrayList arrayList = new ArrayList(D2);
                for (int i14 = 0; i14 < D2; i14++) {
                    int D3 = d0Var.D();
                    long parseSpliceTime2 = !z19 ? TimeSignalCommand.parseSpliceTime(d0Var, j11) : C.TIME_UNSET;
                    arrayList.add(new b(D3, parseSpliceTime2, l0Var.b(parseSpliceTime2), null));
                }
                emptyList = arrayList;
            }
            if (z18) {
                long D4 = d0Var.D();
                boolean z20 = (128 & D4) != 0;
                j14 = ((((D4 & 1) << 32) | d0Var.F()) * 1000) / 90;
                z14 = z20;
            } else {
                z14 = false;
                j14 = C.TIME_UNSET;
            }
            i11 = d0Var.J();
            z13 = z17;
            i12 = d0Var.D();
            i13 = d0Var.D();
            list = emptyList;
            long j15 = parseSpliceTime;
            z12 = z14;
            j13 = j14;
            z11 = z19;
            z10 = z16;
            j12 = j15;
        }
        return new SpliceInsertCommand(F, z15, z10, z13, z11, j12, l0Var.b(j12), list, z12, j13, i11, i12, i13);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.componentSpliceList.get(i12).b(parcel);
        }
        parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }
}

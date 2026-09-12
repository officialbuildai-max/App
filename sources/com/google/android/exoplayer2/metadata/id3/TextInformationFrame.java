package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();

    @Nullable
    public final String description;
    public final String value;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame[] newArray(int i11) {
            return new TextInformationFrame[i11];
        }
    }

    TextInformationFrame(Parcel parcel) {
        super((String) p0.j(parcel.readString()));
        this.description = parcel.readString();
        this.value = (String) p0.j(parcel.readString());
    }

    public TextInformationFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    private static List<Integer> parseId3v2point4TimestampFrameForDate(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return p0.c(this.f25489id, textInformationFrame.f25489id) && p0.c(this.description, textInformationFrame.description) && p0.c(this.value, textInformationFrame.value);
    }

    public int hashCode() {
        int hashCode = (527 + this.f25489id.hashCode()) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(a2.b bVar) {
        String str = this.f25489id;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c11 = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c11 = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c11 = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c11 = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c11 = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c11 = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c11 = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c11 = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c11 = 11;
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c11 = 14;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c11 = 15;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c11 = 16;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c11 = 17;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c11 = 18;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c11 = 19;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c11 = 20;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c11 = 21;
                    break;
                }
                break;
        }
        try {
            switch (c11) {
                case 0:
                case '\n':
                    bVar.L(this.value);
                    return;
                case 1:
                case 11:
                    bVar.Q(this.value);
                    return;
                case 2:
                case '\f':
                    bVar.b0(Integer.valueOf(Integer.parseInt(this.value.substring(2, 4)))).a0(Integer.valueOf(Integer.parseInt(this.value.substring(0, 2))));
                    return;
                case 3:
                case 17:
                    bVar.M(this.value);
                    return;
                case 4:
                case 18:
                    bVar.K(this.value);
                    return;
                case 5:
                case 19:
                    bVar.R(this.value);
                    return;
                case 6:
                case 20:
                    String[] S0 = p0.S0(this.value, "/");
                    bVar.l0(Integer.valueOf(Integer.parseInt(S0[0]))).k0(S0.length > 1 ? Integer.valueOf(Integer.parseInt(S0[1])) : null);
                    return;
                case 7:
                case 16:
                    bVar.i0(this.value);
                    return;
                case '\b':
                case 15:
                    bVar.n0(this.value);
                    return;
                case '\t':
                case 21:
                    bVar.c0(Integer.valueOf(Integer.parseInt(this.value)));
                    return;
                case '\r':
                    List<Integer> parseId3v2point4TimestampFrameForDate = parseId3v2point4TimestampFrameForDate(this.value);
                    int size = parseId3v2point4TimestampFrameForDate.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size != 3) {
                                return;
                            } else {
                                bVar.a0(parseId3v2point4TimestampFrameForDate.get(2));
                            }
                        }
                        bVar.b0(parseId3v2point4TimestampFrameForDate.get(1));
                    }
                    bVar.c0(parseId3v2point4TimestampFrameForDate.get(0));
                    return;
                case 14:
                    List<Integer> parseId3v2point4TimestampFrameForDate2 = parseId3v2point4TimestampFrameForDate(this.value);
                    int size2 = parseId3v2point4TimestampFrameForDate2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 != 3) {
                                return;
                            } else {
                                bVar.d0(parseId3v2point4TimestampFrameForDate2.get(2));
                            }
                        }
                        bVar.e0(parseId3v2point4TimestampFrameForDate2.get(1));
                    }
                    bVar.f0(parseId3v2point4TimestampFrameForDate2.get(0));
                    return;
                default:
                    return;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f25489id + ": description=" + this.description + ": value=" + this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f25489id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}

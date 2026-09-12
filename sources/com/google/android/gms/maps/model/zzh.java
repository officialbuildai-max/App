package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes4.dex */
public final class zzh implements Parcelable.Creator<MarkerOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        float f16 = 0.5f;
        float f17 = 1.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 6:
                    f11 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    f12 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    f13 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 12:
                    f16 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 13:
                    f14 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 14:
                    f17 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 15:
                    f15 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MarkerOptions(latLng, str, str2, iBinder, f11, f12, z10, z11, z12, f13, f16, f14, f17, f15);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MarkerOptions[] newArray(int i11) {
        return new MarkerOptions[i11];
    }
}

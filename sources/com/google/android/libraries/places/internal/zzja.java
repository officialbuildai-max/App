package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzja {

    @Nullable
    private zza[] addressComponents;

    @Nullable
    private String businessStatus;

    @Nullable
    private Boolean curbsidePickup;

    @Nullable
    private zzd currentOpeningHours;

    @Nullable
    private Boolean delivery;

    @Nullable
    private Boolean dineIn;

    @Nullable
    private zzb editorialSummary;

    @Nullable
    private String formattedAddress;

    @Nullable
    private zzc geometry;

    @Nullable
    private String icon;

    @Nullable
    private String iconBackgroundColor;

    @Nullable
    private String iconMaskBaseUri;

    @Nullable
    private String internationalPhoneNumber;

    @Nullable
    private String name;

    @Nullable
    private zzd openingHours;

    @Nullable
    private zze[] photos;

    @Nullable
    private String placeId;

    @Nullable
    private zzf plusCode;

    @Nullable
    private Integer priceLevel;

    @Nullable
    private Double rating;

    @Nullable
    private Boolean reservable;

    @Nullable
    private zzd[] secondaryOpeningHours;

    @Nullable
    private Boolean servesBeer;

    @Nullable
    private Boolean servesBreakfast;

    @Nullable
    private Boolean servesBrunch;

    @Nullable
    private Boolean servesDinner;

    @Nullable
    private Boolean servesLunch;

    @Nullable
    private Boolean servesVegetarianFood;

    @Nullable
    private Boolean servesWine;

    @Nullable
    private Boolean takeout;

    @Nullable
    private String[] types;

    @Nullable
    private Integer userRatingsTotal;

    @Nullable
    private Integer utcOffset;

    @Nullable
    private String website;

    @Nullable
    private Boolean wheelchairAccessibleEntrance;

    /* loaded from: classes4.dex */
    class zza {

        @Nullable
        private String longName;

        @Nullable
        private String shortName;

        @Nullable
        private String[] types;

        zza() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zznx zza() {
            String[] strArr = this.types;
            return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzb() {
            return this.longName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzc() {
            return this.shortName;
        }
    }

    /* loaded from: classes4.dex */
    class zzb {

        @Nullable
        private String language;

        @Nullable
        private String overview;

        zzb() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zza() {
            return this.language;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzb() {
            return this.overview;
        }
    }

    /* loaded from: classes4.dex */
    class zzc {

        @Nullable
        private zza location;

        @Nullable
        private zzb viewport;

        /* loaded from: classes4.dex */
        class zza {

            @Nullable
            private Double lat;

            @Nullable
            private Double lng;

            zza() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final Double zza() {
                return this.lat;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final Double zzb() {
                return this.lng;
            }
        }

        /* loaded from: classes4.dex */
        class zzb {

            @Nullable
            private zza northeast;

            @Nullable
            private zza southwest;

            zzb() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final zza zza() {
                return this.northeast;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final zza zzb() {
                return this.southwest;
            }
        }

        zzc() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final zza zza() {
            return this.location;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final zzb zzb() {
            return this.viewport;
        }
    }

    /* loaded from: classes4.dex */
    class zzd {

        @Nullable
        private zza[] periods;

        @Nullable
        private zzb[] specialDays;

        @Nullable
        private String type;

        @Nullable
        private String[] weekdayText;

        /* loaded from: classes4.dex */
        class zza {

            @Nullable
            private zzc close;

            @Nullable
            private zzc open;

            zza() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final zzc zza() {
                return this.close;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final zzc zzb() {
                return this.open;
            }
        }

        /* loaded from: classes4.dex */
        class zzb {

            @Nullable
            private String date;

            @Nullable
            private Boolean exceptionalHours;

            zzb() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final Boolean zza() {
                return this.exceptionalHours;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final String zzb() {
                return this.date;
            }
        }

        /* loaded from: classes4.dex */
        class zzc {

            @Nullable
            private String date;

            @Nullable
            private Integer day;

            @Nullable
            private String time;

            @Nullable
            private Boolean truncated;

            zzc() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final Boolean zza() {
                return this.truncated;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final Integer zzb() {
                return this.day;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final String zzc() {
                return this.date;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Nullable
            public final String zzd() {
                return this.time;
            }
        }

        zzd() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zznx zza() {
            zza[] zzaVarArr = this.periods;
            return zzaVarArr != null ? zznx.zzk(zzaVarArr) : zznx.zzl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zznx zzb() {
            zzb[] zzbVarArr = this.specialDays;
            return zzbVarArr != null ? zznx.zzk(zzbVarArr) : zznx.zzl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zznx zzc() {
            String[] strArr = this.weekdayText;
            return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzd() {
            return this.type;
        }
    }

    /* loaded from: classes4.dex */
    class zze {

        @Nullable
        private Integer height;

        @Nullable
        private String[] htmlAttributions;

        @Nullable
        private String photoReference;

        @Nullable
        private Integer width;

        zze() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zznx zza() {
            String[] strArr = this.htmlAttributions;
            return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final Integer zzb() {
            return this.height;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final Integer zzc() {
            return this.width;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzd() {
            return this.photoReference;
        }
    }

    /* loaded from: classes4.dex */
    class zzf {

        @Nullable
        private String compoundCode;

        @Nullable
        private String globalCode;

        zzf() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zza() {
            return this.compoundCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public final String zzb() {
            return this.globalCode;
        }
    }

    zzja() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzA() {
        return this.formattedAddress;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzB() {
        return this.iconBackgroundColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzC() {
        return this.iconMaskBaseUri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzD() {
        return this.internationalPhoneNumber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzE() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzF() {
        return this.placeId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzG() {
        return this.website;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzb zza() {
        return this.editorialSummary;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzc zzb() {
        return this.geometry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzd zzc() {
        return this.currentOpeningHours;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzd zzd() {
        return this.openingHours;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzf zze() {
        return this.plusCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznx zzf() {
        zza[] zzaVarArr = this.addressComponents;
        return zzaVarArr != null ? zznx.zzk(zzaVarArr) : zznx.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznx zzg() {
        zze[] zzeVarArr = this.photos;
        return zzeVarArr != null ? zznx.zzk(zzeVarArr) : zznx.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznx zzh() {
        zzd[] zzdVarArr = this.secondaryOpeningHours;
        return zzdVarArr != null ? zznx.zzk(zzdVarArr) : zznx.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zznx zzi() {
        String[] strArr = this.types;
        return strArr != null ? zznx.zzk(strArr) : zznx.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzj() {
        return this.curbsidePickup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzk() {
        return this.delivery;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzl() {
        return this.dineIn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzm() {
        return this.reservable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzn() {
        return this.servesBeer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzo() {
        return this.servesBreakfast;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzp() {
        return this.servesDinner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzq() {
        return this.servesLunch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzr() {
        return this.servesVegetarianFood;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzs() {
        return this.servesWine;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzt() {
        return this.takeout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Boolean zzu() {
        return this.wheelchairAccessibleEntrance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Double zzv() {
        return this.rating;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Integer zzw() {
        return this.priceLevel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Integer zzx() {
        return this.userRatingsTotal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Integer zzy() {
        return this.utcOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzz() {
        return this.businessStatus;
    }
}

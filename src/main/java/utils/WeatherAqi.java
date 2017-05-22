package utils;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

public class WeatherAqi {

    /**
     * HeWeather5 : [{"alarms":[{"txt":"青岛市气象台2016年08月29日15时24分继续发布大风蓝色预警信号：预计今天下午到明天，我市北风风力海上6到7级阵风9级，陆地4到5阵风7级，请注意防范。","stat":"预警中","level":"蓝色","title":"山东省青岛市气象台发布大风蓝色预警","type":"大风"}],"aqi":{"city":{"no2":"14","o3":"95","pm25":"15","qlty":"良","so2":"10","aqi":"60","pm10":"67","co":"0"}}}]
     */
    private List<HeWeather5Entity> HeWeather5;

    public void setHeWeather5(List<HeWeather5Entity> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public List<HeWeather5Entity> getHeWeather5() {
        return HeWeather5;
    }

    public class HeWeather5Entity {
        /**
         * alarms : [{"txt":"青岛市气象台2016年08月29日15时24分继续发布大风蓝色预警信号：预计今天下午到明天，我市北风风力海上6到7级阵风9级，陆地4到5阵风7级，请注意防范。","stat":"预警中","level":"蓝色","title":"山东省青岛市气象台发布大风蓝色预警","type":"大风"}]
         * aqi : {"city":{"no2":"14","o3":"95","pm25":"15","qlty":"良","so2":"10","aqi":"60","pm10":"67","co":"0"}}
         */
        private List<AlarmsEntity> alarms;
        private AqiEntity aqi;

        public void setAlarms(List<AlarmsEntity> alarms) {
            this.alarms = alarms;
        }

        public void setAqi(AqiEntity aqi) {
            this.aqi = aqi;
        }

        public List<AlarmsEntity> getAlarms() {
            return alarms;
        }

        public AqiEntity getAqi() {
            return aqi;
        }

        public class AlarmsEntity {
            /**
             * txt : 青岛市气象台2016年08月29日15时24分继续发布大风蓝色预警信号：预计今天下午到明天，我市北风风力海上6到7级阵风9级，陆地4到5阵风7级，请注意防范。
             * stat : 预警中
             * level : 蓝色
             * title : 山东省青岛市气象台发布大风蓝色预警
             * type : 大风
             */
            private String txt;
            private String stat;
            private String level;
            private String title;
            private String type;

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public void setStat(String stat) {
                this.stat = stat;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTxt() {
                return txt;
            }

            public String getStat() {
                return stat;
            }

            public String getLevel() {
                return level;
            }

            public String getTitle() {
                return title;
            }

            public String getType() {
                return type;
            }
        }

        public class AqiEntity {
            /**
             * city : {"no2":"14","o3":"95","pm25":"15","qlty":"良","so2":"10","aqi":"60","pm10":"67","co":"0"}
             */
            private CityEntity city;

            public void setCity(CityEntity city) {
                this.city = city;
            }

            public CityEntity getCity() {
                return city;
            }

            public class CityEntity {
                /**
                 * no2 : 14
                 * o3 : 95
                 * pm25 : 15
                 * qlty : 良
                 * so2 : 10
                 * aqi : 60
                 * pm10 : 67
                 * co : 0
                 */
                private String no2;
                private String o3;
                private String pm25;
                private String qlty;
                private String so2;
                private String aqi;
                private String pm10;
                private String co;

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public String getO3() {
                    return o3;
                }

                public String getPm25() {
                    return pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public String getAqi() {
                    return aqi;
                }

                public String getPm10() {
                    return pm10;
                }

                public String getCo() {
                    return co;
                }
            }
        }
    }
}

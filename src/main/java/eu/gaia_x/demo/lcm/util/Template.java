package eu.gaia_x.demo.lcm.util;

public class Template {

    public static final String TEMPLATE_1 = "{\n" +
            "    \"services\": [\n" +
            "        {\n" +
            "            \"serviceId\": \"gaia-x_service_id\",\n" +
            "            \"lcmServiceId\": \"lcm_service_id\",\n" +
            "            \"fields\": [\n" +
            "                {\n" +
            "                    \"id\": \"password\",\n" +
            "                    \"label\": \"Database Password\",\n" +
            "                    \"value\": \"123456789\",\n" +
            "                    \"validation\": \"<POSSIBLY_REGEX_FOR_VALIDATION_BUT_CURRENTLY_EMPTY>\",\n" +
            "                    \"description\": \"<SHORT_DESCRIPTION_OF_FIELD_WHICH_WE_CAN_SHOW_IN_TOOLTIP_AS_WELL_AS_VALIDATION_RULE_DESCRIBED_FOR_HUMAN\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": \"login\",\n" +
            "                    \"label\": \"User name\",\n" +
            "                    \"value\": \"123456789\",\n" +
            "                    \"validation\": \"<POSSIBLY_REGEX_FOR_VALIDATION_BUT_CURRENTLY_EMPTY>\",\n" +
            "                    \"description\": \"<SHORT_DESCRIPTION_OF_FIELD_WHICH_WE_CAN_SHOW_IN_TOOLTIP_AS_WELL_AS_VALIDATION_RULE_DESCRIBED_FOR_HUMAN\"\n" +
            "                },\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"serviceId\": \"gaia-x_service_id_2\",\n" +
            "            \"lcmServiceId\": \"lcm_service_id_2\",\n" +
            "            \"fields\": [\n" +
            "                {\n" +
            "                    \"id\": \"password\",\n" +
            "                    \"label\": \"Database Password\",\n" +
            "                    \"value\": \"123456789\",\n" +
            "                    \"validation\": \"<POSSIBLY_REGEX_FOR_VALIDATION_BUT_CURRENTLY_EMPTY>\",\n" +
            "                    \"description\": \"<SHORT_DESCRIPTION_OF_FIELD_WHICH_WE_CAN_SHOW_IN_TOOLTIP_AS_WELL_AS_VALIDATION_RULE_DESCRIBED_FOR_HUMAN\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": \"password\",\n" +
            "                    \"label\": \"Database Password\",\n" +
            "                    \"value\": \"123456789\",\n" +
            "                    \"validation\": \"<POSSIBLY_REGEX_FOR_VALIDATION_BUT_CURRENTLY_EMPTY>\",\n" +
            "                    \"description\": \"<SHORT_DESCRIPTION_OF_FIELD_WHICH_WE_CAN_SHOW_IN_TOOLTIP_AS_WELL_AS_VALIDATION_RULE_DESCRIBED_FOR_HUMAN\"\n" +
            "                },\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static final String LOG = "[Sun Dec 04 04:47:44 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:47:44 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:51:08 2005] [notice] jk2_init() Found child 6725 in scoreboard slot 10\n" +
            "[Sun Dec 04 04:51:09 2005] [notice] jk2_init() Found child 6726 in scoreboard slot 8\n" +
            "[Sun Dec 04 04:51:09 2005] [notice] jk2_init() Found child 6728 in scoreboard slot 6\n" +
            "[Sun Dec 04 04:51:14 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:51:14 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:51:14 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:51:18 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:51:18 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:51:18 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:51:37 2005] [notice] jk2_init() Found child 6736 in scoreboard slot 10\n" +
            "[Sun Dec 04 04:51:38 2005] [notice] jk2_init() Found child 6733 in scoreboard slot 7\n" +
            "[Sun Dec 04 04:51:38 2005] [notice] jk2_init() Found child 6734 in scoreboard slot 9\n" +
            "[Sun Dec 04 04:51:52 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:51:52 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:51:55 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:52:04 2005] [notice] jk2_init() Found child 6738 in scoreboard slot 6\n" +
            "[Sun Dec 04 04:52:04 2005] [notice] jk2_init() Found child 6741 in scoreboard slot 9\n" +
            "[Sun Dec 04 04:52:05 2005] [notice] jk2_init() Found child 6740 in scoreboard slot 7\n" +
            "[Sun Dec 04 04:52:05 2005] [notice] jk2_init() Found child 6737 in scoreboard slot 8\n" +
            "[Sun Dec 04 04:52:12 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:52:12 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:52:12 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:52:15 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:52:15 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 04:52:15 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 04:52:36 2005] [notice] jk2_init() Found child 6748 in scoreboard slot 6\n" +
            "[Sun Dec 04 04:52:36 2005] [notice] jk2_init() Found child 6744 in scoreboard slot 10\n" +
            "[Sun Dec 04 04:52:36 2005] [notice] jk2_init() Found child 6745 in scoreboard slot 8\n" +
            "[Sun Dec 04 04:52:49 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:52:49 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:52:52 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 04:52:52 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:53:05 2005] [notice] jk2_init() Found child 6750 in scoreboard slot 7\n" +
            "[Sun Dec 04 04:53:05 2005] [notice] jk2_init() Found child 6751 in scoreboard slot 9\n" +
            "[Sun Dec 04 04:53:05 2005] [notice] jk2_init() Found child 6752 in scoreboard slot 10\n" +
            "[Sun Dec 04 04:53:15 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:53:15 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:53:16 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 04:53:16 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:53:29 2005] [notice] jk2_init() Found child 6754 in scoreboard slot 8\n" +
            "[Sun Dec 04 04:53:29 2005] [notice] jk2_init() Found child 6755 in scoreboard slot 6\n" +
            "[Sun Dec 04 04:53:40 2005] [notice] jk2_init() Found child 6756 in scoreboard slot 7\n" +
            "[Sun Dec 04 04:53:51 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:53:54 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 04:54:15 2005] [notice] jk2_init() Found child 6763 in scoreboard slot 10\n" +
            "[Sun Dec 04 04:54:15 2005] [notice] jk2_init() Found child 6766 in scoreboard slot 6\n" +
            "[Sun Dec 04 04:54:15 2005] [notice] jk2_init() Found child 6767 in scoreboard slot 7\n" +
            "[Sun Dec 04 04:54:15 2005] [notice] jk2_init() Found child 6765 in scoreboard slot 8\n" +
            "[Sun Dec 04 04:54:18 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:54:18 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:54:18 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:54:18 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:54:18 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:54:18 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:54:18 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 04:54:18 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 04:54:20 2005] [notice] jk2_init() Found child 6768 in scoreboard slot 9\n" +
            "[Sun Dec 04 04:54:20 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:54:20 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:56:52 2005] [notice] jk2_init() Found child 8527 in scoreboard slot 10\n" +
            "[Sun Dec 04 04:56:52 2005] [notice] jk2_init() Found child 8533 in scoreboard slot 8\n" +
            "[Sun Dec 04 04:56:57 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:56:57 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:56:59 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:57:00 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:57:20 2005] [notice] jk2_init() Found child 8536 in scoreboard slot 6\n" +
            "[Sun Dec 04 04:57:20 2005] [notice] jk2_init() Found child 8539 in scoreboard slot 7\n" +
            "[Sun Dec 04 04:57:24 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:57:24 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:57:24 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:57:24 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:57:49 2005] [notice] jk2_init() Found child 8541 in scoreboard slot 9\n" +
            "[Sun Dec 04 04:58:11 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:58:18 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:58:45 2005] [notice] jk2_init() Found child 8547 in scoreboard slot 10\n" +
            "[Sun Dec 04 04:58:57 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:58:58 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:59:28 2005] [notice] jk2_init() Found child 8554 in scoreboard slot 6\n" +
            "[Sun Dec 04 04:59:27 2005] [notice] jk2_init() Found child 8553 in scoreboard slot 8\n" +
            "[Sun Dec 04 04:59:35 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:59:35 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 04:59:38 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 04:59:38 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:00:03 2005] [notice] jk2_init() Found child 8560 in scoreboard slot 7\n" +
            "[Sun Dec 04 05:00:09 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:00:09 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:00:13 2005] [notice] jk2_init() Found child 8565 in scoreboard slot 9\n" +
            "[Sun Dec 04 05:00:13 2005] [notice] jk2_init() Found child 8573 in scoreboard slot 10\n" +
            "[Sun Dec 04 05:00:15 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:00:15 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:00:15 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:00:15 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:01:20 2005] [notice] jk2_init() Found child 8584 in scoreboard slot 7\n" +
            "[Sun Dec 04 05:01:20 2005] [notice] jk2_init() Found child 8587 in scoreboard slot 9\n" +
            "[Sun Dec 04 05:02:14 2005] [notice] jk2_init() Found child 8603 in scoreboard slot 10\n" +
            "[Sun Dec 04 05:02:14 2005] [notice] jk2_init() Found child 8605 in scoreboard slot 8\n" +
            "[Sun Dec 04 05:04:03 2005] [notice] jk2_init() Found child 8764 in scoreboard slot 10\n" +
            "[Sun Dec 04 05:04:03 2005] [notice] jk2_init() Found child 8765 in scoreboard slot 11\n" +
            "[Sun Dec 04 05:04:03 2005] [notice] jk2_init() Found child 8763 in scoreboard slot 9\n" +
            "[Sun Dec 04 05:04:03 2005] [notice] jk2_init() Found child 8744 in scoreboard slot 8\n" +
            "[Sun Dec 04 05:04:03 2005] [notice] jk2_init() Found child 8743 in scoreboard slot 7\n" +
            "[Sun Dec 04 05:04:03 2005] [notice] jk2_init() Found child 8738 in scoreboard slot 6\n" +
            "[Sun Dec 04 05:04:03 2005] [notice] jk2_init() Found child 8766 in scoreboard slot 12\n" +
            "[Sun Dec 04 05:04:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:04:04 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 05:04:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:04:04 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:04:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:04:04 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 05:04:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:04:04 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 05:04:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:04:04 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 05:04:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:04:04 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:04:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:04:04 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:11:51 2005] [notice] jk2_init() Found child 25792 in scoreboard slot 6\n" +
            "[Sun Dec 04 05:12:07 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:12:10 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:12:26 2005] [notice] jk2_init() Found child 25798 in scoreboard slot 7\n" +
            "[Sun Dec 04 05:12:26 2005] [notice] jk2_init() Found child 25803 in scoreboard slot 8\n" +
            "[Sun Dec 04 05:12:28 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:12:28 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:12:28 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:12:28 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:12:30 2005] [notice] jk2_init() Found child 25805 in scoreboard slot 9\n" +
            "[Sun Dec 04 05:12:30 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:12:30 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 05:15:09 2005] [error] [client 222.166.160.184] Directory index forbidden by rule: /var/www/html/\n" +
            "[Sun Dec 04 05:15:13 2005] [notice] jk2_init() Found child 1000 in scoreboard slot 10\n" +
            "[Sun Dec 04 05:15:16 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 05:15:16 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:01:00 2005] [notice] jk2_init() Found child 32347 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:01:00 2005] [notice] jk2_init() Found child 32348 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:01:21 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:01:21 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:01:30 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:01:42 2005] [notice] jk2_init() Found child 32352 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:01:42 2005] [notice] jk2_init() Found child 32353 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:01:42 2005] [notice] jk2_init() Found child 32354 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:02:01 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:02:02 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:02:05 2005] [notice] jk2_init() Found child 32359 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:02:05 2005] [notice] jk2_init() Found child 32360 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:02:05 2005] [notice] jk2_init() Found child 32358 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:02:05 2005] [notice] jk2_init() Found child 32355 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:02:07 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:02:07 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:02:07 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:02:07 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:02:07 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:02:07 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:02:07 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:02:07 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:06:00 2005] [notice] jk2_init() Found child 32388 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:06:00 2005] [notice] jk2_init() Found child 32387 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:06:00 2005] [notice] jk2_init() Found child 32386 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:06:10 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:06:11 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:06:12 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:06:12 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:06:20 2005] [notice] jk2_init() Found child 32389 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:06:24 2005] [notice] jk2_init() Found child 32391 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:06:24 2005] [notice] jk2_init() Found child 32390 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:06:24 2005] [notice] jk2_init() Found child 32392 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:06:26 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:06:26 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:06:26 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:06:26 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:06:26 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:06:26 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:06:26 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:06:26 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:11:11 2005] [notice] jk2_init() Found child 32410 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:11:11 2005] [notice] jk2_init() Found child 32411 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:12:31 2005] [notice] jk2_init() Found child 32423 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:12:31 2005] [notice] jk2_init() Found child 32422 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:12:31 2005] [notice] jk2_init() Found child 32419 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:12:31 2005] [notice] jk2_init() Found child 32421 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:12:31 2005] [notice] jk2_init() Found child 32420 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:12:31 2005] [notice] jk2_init() Found child 32424 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:12:37 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:12:37 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:12:37 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:12:37 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:12:37 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:12:40 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:12:40 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:12:40 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:12:40 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:12:40 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:12:59 2005] [notice] jk2_init() Found child 32425 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:13:01 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:13:01 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:16:10 2005] [notice] jk2_init() Found child 32432 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:16:10 2005] [notice] jk2_init() Found child 32434 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:16:10 2005] [notice] jk2_init() Found child 32433 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:16:21 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:16:21 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:16:23 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:16:23 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:16:21 2005] [notice] jk2_init() Found child 32435 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:16:21 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:16:23 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:16:37 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:16:39 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:16:51 2005] [notice] jk2_init() Found child 32436 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:16:51 2005] [notice] jk2_init() Found child 32437 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:17:02 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:17:02 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:17:05 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:17:06 2005] [notice] jk2_init() Found child 32438 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:17:18 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:17:24 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:17:23 2005] [notice] jk2_init() Found child 32440 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:17:23 2005] [notice] jk2_init() Found child 32439 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:17:23 2005] [notice] jk2_init() Found child 32441 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:17:33 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:17:33 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:17:35 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:17:35 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:17:55 2005] [notice] jk2_init() Found child 32442 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:17:55 2005] [notice] jk2_init() Found child 32443 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:17:55 2005] [notice] jk2_init() Found child 32444 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:18:08 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:18:08 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:18:11 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:18:11 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:18:12 2005] [notice] jk2_init() Found child 32445 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:18:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:18:31 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:18:41 2005] [notice] jk2_init() Found child 32447 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:18:39 2005] [notice] jk2_init() Found child 32446 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:18:40 2005] [notice] jk2_init() Found child 32448 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:18:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:18:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:18:55 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:18:55 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:19:05 2005] [notice] jk2_init() Found child 32449 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:19:15 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:19:19 2005] [notice] jk2_init() Found child 32450 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:19:18 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:19:19 2005] [notice] jk2_init() Found child 32452 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:19:19 2005] [notice] jk2_init() Found child 32451 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:19:31 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:19:31 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:19:34 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:19:34 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:19:56 2005] [notice] jk2_init() Found child 32454 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:19:56 2005] [notice] jk2_init() Found child 32453 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:19:56 2005] [notice] jk2_init() Found child 32455 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:20:30 2005] [notice] jk2_init() Found child 32467 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:20:30 2005] [notice] jk2_init() Found child 32464 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:20:30 2005] [notice] jk2_init() Found child 32465 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:20:30 2005] [notice] jk2_init() Found child 32466 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:20:30 2005] [notice] jk2_init() Found child 32457 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:20:44 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:20:44 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:20:44 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:20:46 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:20:46 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:20:46 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:22:18 2005] [notice] jk2_init() Found child 32475 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:22:48 2005] [notice] jk2_init() Found child 32478 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:22:48 2005] [notice] jk2_init() Found child 32477 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:22:48 2005] [notice] jk2_init() Found child 32479 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:22:48 2005] [notice] jk2_init() Found child 32480 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:22:48 2005] [notice] jk2_init() Found child 32476 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:22:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:22:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:22:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:22:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:22:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:22:55 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:22:55 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:22:55 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:22:55 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:22:55 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:23:12 2005] [notice] jk2_init() Found child 32483 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:23:15 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:23:15 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:30:41 2005] [notice] jk2_init() Found child 32507 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:30:43 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:30:43 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:36:07 2005] [notice] jk2_init() Found child 32529 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:36:07 2005] [notice] jk2_init() Found child 32528 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:36:10 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:36:10 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:36:10 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:36:10 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:40:54 2005] [notice] jk2_init() Found child 32548 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:40:54 2005] [notice] jk2_init() Found child 32546 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:40:55 2005] [notice] jk2_init() Found child 32547 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:41:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:41:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:41:04 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:41:07 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:41:08 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:41:08 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:41:29 2005] [notice] jk2_init() Found child 32549 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:41:29 2005] [notice] jk2_init() Found child 32550 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:41:45 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:41:45 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:41:46 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:41:46 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:42:11 2005] [notice] jk2_init() Found child 32551 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:42:11 2005] [notice] jk2_init() Found child 32552 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:42:25 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:42:23 2005] [notice] jk2_init() Found child 32554 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:42:25 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:42:23 2005] [notice] jk2_init() Found child 32553 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:42:30 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:42:30 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:42:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:42:53 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:42:58 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:42:58 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:43:20 2005] [notice] jk2_init() Found child 32556 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:43:20 2005] [notice] jk2_init() Found child 32555 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:43:20 2005] [notice] jk2_init() Found child 32557 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:43:34 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:43:34 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:43:34 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:43:40 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:43:40 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:43:56 2005] [notice] jk2_init() Found child 32558 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:44:18 2005] [notice] jk2_init() Found child 32560 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:44:18 2005] [notice] jk2_init() Found child 32561 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:44:39 2005] [notice] jk2_init() Found child 32563 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:44:39 2005] [notice] jk2_init() Found child 32564 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:44:39 2005] [notice] jk2_init() Found child 32565 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:45:32 2005] [notice] jk2_init() Found child 32575 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:45:32 2005] [notice] jk2_init() Found child 32576 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:45:32 2005] [notice] jk2_init() Found child 32569 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:45:32 2005] [notice] jk2_init() Found child 32572 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:45:32 2005] [notice] jk2_init() Found child 32577 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:45:50 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:45:50 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:45:57 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:46:13 2005] [notice] jk2_init() Found child 32578 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:46:13 2005] [notice] jk2_init() Found child 32580 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:46:12 2005] [notice] jk2_init() Found child 32581 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:46:13 2005] [notice] jk2_init() Found child 32579 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:46:30 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:46:30 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:46:31 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:46:31 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:46:32 2005] [notice] jk2_init() Found child 32582 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:46:32 2005] [notice] jk2_init() Found child 32584 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:46:32 2005] [notice] jk2_init() Found child 32583 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:46:33 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:46:33 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:46:34 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:46:34 2005] [error] mod_jk child workerEnv in error state 10\n" +
            "[Sun Dec 04 06:46:34 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:46:34 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:47:19 2005] [notice] jk2_init() Found child 32585 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:47:30 2005] [notice] jk2_init() Found child 32587 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:47:30 2005] [notice] jk2_init() Found child 32586 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:47:34 2005] [notice] jk2_init() Found child 32588 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:47:38 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:47:39 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:47:39 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:47:43 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:48:09 2005] [notice] jk2_init() Found child 32592 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:48:09 2005] [notice] jk2_init() Found child 32591 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:48:22 2005] [notice] jk2_init() Found child 32594 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:48:22 2005] [notice] jk2_init() Found child 32593 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:48:48 2005] [notice] jk2_init() Found child 32597 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:49:06 2005] [notice] jk2_init() Found child 32600 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:49:06 2005] [notice] jk2_init() Found child 32601 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:49:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:49:24 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:49:40 2005] [notice] jk2_init() Found child 32605 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:49:40 2005] [notice] jk2_init() Found child 32604 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:51:13 2005] [notice] jk2_init() Found child 32622 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:51:14 2005] [notice] jk2_init() Found child 32623 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:51:13 2005] [notice] jk2_init() Found child 32624 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:51:13 2005] [notice] jk2_init() Found child 32621 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:51:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:51:23 2005] [error] mod_jk child workerEnv in error state 7\n" +
            "[Sun Dec 04 06:51:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:51:23 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:51:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:51:23 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:51:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:51:23 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:51:25 2005] [notice] jk2_init() Found child 32626 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:51:26 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:51:26 2005] [error] mod_jk child workerEnv in error state 9\n" +
            "[Sun Dec 04 06:52:07 2005] [notice] jk2_init() Found child 32627 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:52:08 2005] [notice] jk2_init() Found child 32628 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:52:13 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:52:14 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:52:15 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:52:15 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:52:27 2005] [notice] jk2_init() Found child 32630 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:52:27 2005] [notice] jk2_init() Found child 32629 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:52:39 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:52:39 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:52:41 2005] [error] mod_jk child workerEnv in error state 9\n" +
            "[Sun Dec 04 06:52:41 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:53:04 2005] [notice] jk2_init() Found child 32633 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:53:04 2005] [notice] jk2_init() Found child 32634 in scoreboard slot 11\n" +
            "[Sun Dec 04 06:53:04 2005] [notice] jk2_init() Found child 32632 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:53:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:53:26 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:53:38 2005] [notice] jk2_init() Found child 32636 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:53:37 2005] [notice] jk2_init() Found child 32637 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:53:37 2005] [notice] jk2_init() Found child 32638 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:54:04 2005] [notice] jk2_init() Found child 32640 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:54:04 2005] [notice] jk2_init() Found child 32641 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:54:04 2005] [notice] jk2_init() Found child 32642 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:54:35 2005] [notice] jk2_init() Found child 32646 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:55:00 2005] [notice] jk2_init() Found child 32648 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:55:00 2005] [notice] jk2_init() Found child 32652 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:55:00 2005] [notice] jk2_init() Found child 32649 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:55:00 2005] [notice] jk2_init() Found child 32651 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:55:00 2005] [notice] jk2_init() Found child 32650 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:55:19 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:55:19 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:55:19 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:55:23 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:55:23 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:55:23 2005] [error] mod_jk child workerEnv in error state 9\n" +
            "[Sun Dec 04 06:55:55 2005] [notice] jk2_init() Found child 32660 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:55:54 2005] [notice] jk2_init() Found child 32658 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:55:54 2005] [notice] jk2_init() Found child 32659 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:55:54 2005] [notice] jk2_init() Found child 32657 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:56:10 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:56:17 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:56:37 2005] [notice] jk2_init() Found child 32663 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:56:37 2005] [notice] jk2_init() Found child 32664 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:57:19 2005] [notice] jk2_init() Found child 32670 in scoreboard slot 6\n" +
            "[Sun Dec 04 06:57:19 2005] [notice] jk2_init() Found child 32667 in scoreboard slot 9\n" +
            "[Sun Dec 04 06:57:19 2005] [notice] jk2_init() Found child 32668 in scoreboard slot 10\n" +
            "[Sun Dec 04 06:57:19 2005] [notice] jk2_init() Found child 32669 in scoreboard slot 8\n" +
            "[Sun Dec 04 06:57:19 2005] [notice] jk2_init() Found child 32671 in scoreboard slot 7\n" +
            "[Sun Dec 04 06:57:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:57:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:57:23 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:57:23 2005] [error] mod_jk child workerEnv in error state 6\n" +
            "[Sun Dec 04 06:57:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:57:23 2005] [error] mod_jk child workerEnv in error state 9\n" +
            "[Sun Dec 04 06:57:23 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:57:23 2005] [error] mod_jk child workerEnv in error state 8\n" +
            "[Sun Dec 04 06:57:24 2005] [notice] workerEnv.init() ok /etc/httpd/conf/workers2.properties\n" +
            "[Sun Dec 04 06:57:24 2005] [error] mod_jk child workerEnv in error state 9\n";
}

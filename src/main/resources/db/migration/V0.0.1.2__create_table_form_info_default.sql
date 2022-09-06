create table if not exists form_info_default
(
    id                                          serial not null,
    form_id                                     bigint not null,
    person_id                                   bigint not null,
    psychophysiological_health                  varchar(256),
    is_allergic                                 varchar(256),
    has_pets                                    varchar(256),
    how_faster_ambulance_work                   varchar(256),
    price_of_services                           varchar(256),
    would_you_recommend                         varchar(256),
    your_recommendation                         varchar(256),
    chronic_diseases                            varchar(256),
    is_carefully_doctor_listening               varchar(256),
    is_answered_doctor_the_question             varchar(256),
    doctor_communicate_politely                 varchar(256),
    rate_of_comfort_in_hospital                 varchar(256),
    rate_of_orientation_into_hospital           varchar(256),
    technical_equipment_doctors_office          varchar(256),
    technical_equipment_waiting_room            varchar(256),
    appointment_wanted_day                      varchar(256),
    how_long_offer_wait_by_administrator        varchar(256),
    can_choose_dentist_by_self                  varchar(256),
    how_much_time_wait_for_dentist              varchar(256),
    quality_of_dental_care                      varchar(256),
    prices_correspond_quality                   varchar(256),
    familiarize_treatment_plan                  varchar(256),
    uses_services_in_the_future                 varchar(256),
    competence_of_doctor                        varchar(256),
    last_time_of_medical_examination            varchar(256),
    medical_examination_carried_out_fully       varchar(256),
    consultation_via_the_internet               varchar(256),
    been_sick_coronavirus                       varchar(256),
    stomach_pains                               varchar(256),
    back_pain                                   varchar(256),
    pain_of_arms_legs_and_joints                varchar(256),
    head_pain                                   varchar(256),
    chest_pain                                  varchar(256),
    dizziness                                   varchar(256),
    fainting                                    varchar(256),
    slowing_down_speeding_heartbeats            varchar(256),
    feeling_of_lack_of_air                      varchar(256),
    diarrhea_or_frequent_urination              varchar(256),
    last_month_stomach_pain                     varchar(256),
    last_month_dyspepsia_or_nausea              varchar(256),
    last_month_weakness_or_lost_energy          varchar(256),
    last_month_sleep_disturbance                varchar(256),
    last_month_uncontrolled_food_intake         varchar(256),
    last_month_previously_pleasant_activities   varchar(256),
    low_mood_last_month                         varchar(256),
    nervousness_last_month                      varchar(256),
    feelings_of_fear_and_panic_last_month       varchar(256),
    rate_you_health                             varchar(256),
    allergic_to_medications                     varchar(256),
    weight_loss                                 varchar(256),
    clench_teeth_in_daytime                     varchar(256),
    smoker                                      varchar(256),
    how_difficult_to_read_books                 varchar(256),
    how_difficult_to_recognize_numbers_on_phone varchar(256),
    how_difficult_to_recognize_people_up_close  varchar(256),
    how_difficult_small_scale_manual_work       varchar(256),
    how_difficult_to_fill_form                  varchar(256),
    how_difficult_play_boardgames               varchar(256),
    how_difficult_cooking                       varchar(256),
    has_difficult_to_drive_car_in_the_daytime   varchar(256),
    has_difficult_to_drive_car_in_the_dark      varchar(256),

    constraint pk_form_info_default primary key (id)
)
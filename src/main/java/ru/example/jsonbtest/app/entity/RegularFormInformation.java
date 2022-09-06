package ru.example.jsonbtest.app.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "form_info_default")
public class RegularFormInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "form_id", nullable = false)
    private Long formId;

    @Column(name = "person_id", nullable = false)
    private Long personId;

    private String psychophysiologicalHealth;

    private String isAllergic;

    private String hasPets;

    private String howFasterAmbulanceWork;

    private String priceOfServices;

    private String wouldYouRecommend;

    private String yourRecommendation;

    private String chronicDiseases;

    private String isCarefullyDoctorListening;

    private String isAnsweredDoctorTheQuestion;


    private String doctorCommunicatePolitely;

    private String rateOfComfortInHospital;

    private String rateOfOrientationIntoHospital;

    private String technicalEquipmentDoctorsOffice;

    private String technicalEquipmentWaitingRoom;

    private String appointmentWantedDay;

    private String howLongOfferWaitByAdministrator;

    private String canChooseDentistBySelf;

    private String howMuchTimeWaitForDentist;

    private String qualityOfDentalCare;

    private String pricesCorrespondQuality;

    private String familiarizeTreatmentPlan;

    private String usesServicesInTheFuture;

    private String competenceOfDoctor;

    private String lastTimeOfMedicalExamination;

    private String medicalExaminationCarriedOutFully;

    private String consultationViaTheInternet;

    private String beenSickCoronavirus;

    private String stomachPains;

    private String backPain;

    private String painOfArmsLegsAndJoints;

    private String headPain;

    private String chestPain;

    private String dizziness;

    private String fainting;

    private String slowingDownSpeedingHeartbeats;

    private String feelingOfLackOfAir;

    private String diarrheaOrFrequentUrination;

    private String lastMonthStomachPain;

    private String lastMonthDyspepsiaOrNausea;

    private String lastMonthWeaknessOrLostEnergy;

    private String lastMonthSleepDisturbance;

    private String lastMonthUncontrolledFoodIntake;

    private String lastMonthPreviouslyPleasantActivities;

    private String lowMoodLastMonth;

    private String nervousnessLastMonth;

    private String feelingsOfFearAndPanicLastMonth;

    private String rateYouHealth;

    private String allergicToMedications;

    private String weightLoss;

    private String clenchTeethInDaytime;

    private String smoker;

    private String howDifficultToReadBooks;

    private String howDifficultToRecognizeNumbersOnPhone;

    private String howDifficultToRecognizePeopleUpClose;

    private String howDifficultSmallScaleManualWork;

    private String howDifficultToFillForm;

    private String howDifficultPlayBoardgames;

    private String howDifficultCooking;

    private String hasDifficultToDriveCarInTheDaytime;

    private String hasDifficultToDriveCarInTheDark;


}

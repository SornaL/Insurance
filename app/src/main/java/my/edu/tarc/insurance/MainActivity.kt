package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ActivitymainBinding is an auto generated name
        val binding = ActivityMainBinding.inflate(layoutInflater)

       // setContentView(R.layout.activity_main)
       //bind the layout to root
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{

            var basic : Int = 0
            var extra : Int = 0

            //AGE
            val age = binding.spinnerAge.selectedItemPosition
            if(age==0){
                basic = 60
            }
            else if(age==1){
                basic = 70
            }
            else if(age==2){
                basic = 90
            }
            else if(age==3){
                basic = 120
            }
            else if(age==4){
                basic = 150
            }
            else{
                basic = 150
            }


            //GENDER
            val gender = binding.radioGroupGender.checkedRadioButtonId

            //GENDER == MALE
            if(gender == binding.radioButtonMale.id){
                //Calculate extra payment for male
                if(age == 0){
                    extra = 0
                }
                else if(age==1){
                    extra = 50
                }
                else if(age==2){
                    extra = 100
                }
                else if(age==3){
                    extra = 150
                }
                else if(age==4){
                    extra = 200
                }
                else{
                    extra = 200
                }
            }

            //GENDER == FEMALE
            else if(gender == binding.radioButtonFemale.id){
                if(age == 0){
                    extra = 0
                }
                else if(age==1){
                    extra = 0
                }
                else if(age==2){
                    extra = 0
                }
                else if(age==3){
                    extra = 0
                }
                else if(age==4){
                    extra = 0
                }
                else{
                    extra = 0
                }
            }


            //SMOKER or not
            val smoker = binding.checkBoxSmoker.isChecked
            if(gender == binding.radioButtonFemale.id) {
                if (smoker) {
                    //Calculate extra payment for smoker
                    if (age == 0) {
                        extra = 0
                    } else if (age == 1) {
                        extra = 100
                    } else if (age == 2) {
                        extra = 150
                    } else if (age == 3) {
                        extra = 200
                    } else if (age == 4) {
                        extra = 250
                    } else {
                        extra = 300
                    }
                }
            }

            else if(gender == binding.radioButtonMale.id) {
                if (smoker) {
                    //Calculate extra payment for smoker
                    if (age == 0) {
                        extra = 0
                    } else if (age == 1) {
                        extra = 150
                    } else if (age == 2) {
                        extra = 250
                    } else if (age == 3) {
                        extra = 350
                    } else if (age == 4) {
                        extra = 450
                    } else {
                        extra = 500
                    }
                }
            }

            //PREMIUM CALCULATION
            val premium = Premium(basic, extra, basic + extra)
            binding.myPremium = premium

        }

        binding.buttonReset.setOnClickListener{
            binding.myPremium = Premium()

        }

    }
}
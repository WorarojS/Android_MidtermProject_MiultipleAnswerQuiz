package com.s.wrj.android_midterm_project;

public class QuestionLibrary {

    private  String  mQuestions [] = {
            "There is a vehicle directly in the blind spot of Car A, which one is it?",
            "The traffic signal has just turned yellow. There are no other vehicles around. Vehicle A should",
            "How much space should you leave beside you while passing a cyclist?",
            "A flashing red light means:",
            "Cyclists may swerve to the left and right while on a road as they need to avoid hazards or deal with windy conditions. What is a good practice when passing a cyclist?",
            "This sign tells you",
            "You should never sneak behind a truck when it is backing up because",
            "The beginning of a rainfall may cause roads to be particularly slippery because",
            "When will you see green lights flashing at a railway crossing?",
            "If you feel sleepy while driving you should,",
            "Letting up on the brake just before hitting a large animal that you can't avoid",


    };

    private int mQuestionPic [] = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.none,
            R.drawable.three,
            R.drawable.none,
            R.drawable.four,
            R.drawable.none,
            R.drawable.none,
            R.drawable.none,
            R.drawable.none,
            R.drawable.none,

    };

    private String mChoises [] [] = {
            {"Car D","Car C",
                    "Car B",
                    "Car E"},

            {"slow donw and stop since it is safe to do so.",
                    "speed up and make it through before it turn red.",
                    "scan the intersection, maintain speed, and go straight through.",
                    "stop, and then proceed through the red light since there is no other traffic."},

            {"Allow as much as is safely possible. One metre or more.",
            "Allow up to a metre between you and the cyclist.",
            "Do not adjust your position in the lane.",
            "You should never pass a cyclist unless they are riding in a designated bicycle lane."},

            {"Stop and proceed when it is safe to do so.",
            "Stop until the light changes to a flashing yellow light.",
            "Stop until light change to a flashing green light.",
            "Slow down and proceed through intersection if safe."},

            {"Leave them as much as possible.",
                    "Always maintain your established lane position.",
                    "honk your horn before passing them.",
                    "only pass cyclists if thet are riding in a designated bicycle lane. Otherwise, you are not permit to pass cyclists",

            },

            {"the fastest you may drive under ideal conditions",
                    "the ideal speed for this road in any conditions",
                    "the maximum speed unless you are passing",
                    "that there is a faster speed limit ahead"

            },

            {"it is dangerous if you enter one of its blind spots.",
            "they have a less effective braking system than cars.",
            "they carry more weight than your vehicle.",
            "the truck may create too much turbulence."},

            {"the water mixes with oil on the road.",
                    "the water cools the road down quickly.",
            "the water washes the road clean quickly.",
            "you tires become cold.",
            },

            {"There are no flashing green lights at a railway crossing.",
            "After the train has passed as a signal for you to go forward.",
            "When there are no trains coming.",
            "At night time to help you see the train signals better."},

            {"stop somewhere safe, lock your doors, and nap.",
            "open the window and maintain speed.",
            "reduce speed and drive with care.",
            "turn up the radio and maintain speed."},

            {"lessens the chance of it going through the windshield.",
                    "damages the animal less.",
            "minimizes the damage to your car.",
                    "stop the car from skidding."}
    };

    private String mCorrectAnswers [] = {
            "Car D",
            "slow donw and stop since it is safe to do so.",
            "Allow as much as is safely possible. One metre or more.",
            "Stop and proceed when it is safe to do so.",
            "Leave them as much as possible.",
            "the fastest you may drive under ideal conditions",
            "it is dangerous if you enter one of its blind spots.",
            "the water mixes with oil on the road.",
            "There are no flashing green lights at a railway crossing.",
            "stop somewhere safe, lock your doors, and nap.",
            "lessens the chance of it going through the windshield.",

    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoises[a][0];
        return choice0;

    }
    public String getChoice2(int a) {
        String choice1 = mChoises[a][1];
        return choice1;

    }
    public String getChoice3(int a) {
        String choice2 = mChoises[a][2];
        return choice2;

    }

    public String getChoice4(int a) {
        String choice3 = mChoises[a][3];
        return choice3;

    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public int getmQuestionPic(int a) {
        int QuestionPic = mQuestionPic[a];
        return QuestionPic;
    }

}

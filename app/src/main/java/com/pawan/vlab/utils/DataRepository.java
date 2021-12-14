package com.pawan.vlab.utils;

import android.util.Pair;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.pawan.vlab.R;
import com.pawan.vlab.models.ExperimentData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class DataRepository {
    private static final int maxDataPoints = 10000;
    private static final double stepSizeX = 0.01;

    //Title of experiments
    private static final String
            TITLE_EXP_1 = "Half wave rectifier",
            TITLE_EXP_2 = "Full wave rectifier",
            TITLE_EXP_3 = "Op-Amp as Differentiator",
            TITLE_EXP_4 = "Op-Amp as Integrator";

    //Aim of experiments
    private static final String
            AIM_EXP_1 = "To generate output waveform of a half-wave rectifier",
            AIM_EXP_2 = "To generate output waveform of a full-wave rectifier",
            AIM_EXP_3 = "To use op-amp as a differentiator circuit",
            AIM_EXP_4 = "To use op-amp as an integrator circuit";

    //Component List
    private static final String
            AC_SOURCE = "AC source",
            RESISTOR = "Resistor",
            DIODE = "Diode",
            OP_AMP = "Operational Amplifier",
            GROUND = "Ground",
            CAPACITOR = "Capacitor";

    //Components Required
    private static final List<String>
            COM_LIST_EXP_1 = Arrays.asList(AC_SOURCE, RESISTOR, DIODE),
            COM_LIST_EXP_2 = Arrays.asList(AC_SOURCE, RESISTOR, DIODE),
            COM_LIST_EXP_3 = Arrays.asList(OP_AMP, RESISTOR, CAPACITOR),
            COM_LIST_EXP_4 = Arrays.asList(OP_AMP, RESISTOR, CAPACITOR);

    //Theory of Experiments
    private static final String
            THEORY_EXP_1 = "A rectifier is a circuit which converts the Alternating Current (AC) input power into a Direct Current (DC) output power. The input power supply may be either a single-phase or a multi-phase supply with the simplest of all the rectifier circuits being that of the Half Wave Rectifier.\n" +
            "\n" +
            "The power diode in a half wave rectifier circuit passes just one half of each complete sine wave of the AC supply in order to convert it into a DC supply. Then this type of circuit is called a “half-wave” rectifier because it passes only half of the incoming AC power supply as shown below. During each “positive” half cycle of the AC sine wave, the diode is forward biased as the anode is positive with respect to the cathode resulting in current flowing through the diode.\n" +
            "\n" +
            "Since the DC load is resistive (resistor, R), the current flowing in the load resistor is therefore proportional to the voltage (Ohm´s Law), and the voltage across the load resistor will therefore be the same as the supply voltage, Vs (minus Vƒ), that is the “DC” voltage across the load is sinusoidal for the first half cycle only so Vout = Vs.\n" +
            "\n" +
            "During each “negative” half cycle of the AC sinusoidal input waveform, the diode is reverse biased as the anode is negative with respect to the cathode. Therefore, NO current flows through the diode or circuit. Then in the negative half cycle of the supply, no current flows in the load resistor as no voltage appears across it so therefore, Vout = 0.\n" +
            "\n" +
            "The current on the DC side of the circuit flows in one direction only making the circuit Unidirectional. As the load resistor receives from the diode a positive half of the waveform, zero volts, a positive half of the waveform, zero volts, etc, the value of this irregular voltage would be equal in value to an equivalent DC voltage of 0.318*Vmax of the input sinusoidal waveform or 0.45*Vrms of the input sinusoidal waveform.",
            THEORY_EXP_2 = "Like the half wave circuit, a full wave rectifier circuit produces an output voltage or current which is purely DC or has some specified DC component. Full wave rectifiers have some fundamental advantages over their half wave rectifier counterparts. The average (DC) output voltage is higher than for half wave, the output of the full wave rectifier has much less ripple than that of the half wave rectifier producing a smoother output waveform.\n" +
                    "\n" +
                    "In a Full Wave Rectifier circuit two diodes are now used, one for each half of the cycle. A multiple winding transformer is used whose secondary winding is split equally into two halves with a common centre tapped connection, (C). This configuration results in each diode conducting in turn when its anode terminal is positive with respect to the transformer centre point C producing an output during both half-cycles, twice that for the half wave rectifier so it is 100% efficient. The full wave rectifier circuit consists of two power diodes connected to a single load resistance (RL) with each diode taking it in turn to supply current to the load. When point A of the transformer is positive with respect to point C, diode D1 conducts in the forward direction as indicated by the arrows.\n" +
                    "\n" +
                    "When point B is positive (in the negative half of the cycle) with respect to point C, diode D2 conducts in the forward direction and the current flowing through resistor R is in the same direction for both half-cycles. As the output voltage across the resistor R is the phasor sum of the two waveforms combined, this type of full wave rectifier circuit is also known as a “bi-phase” circuit.",
            THEORY_EXP_3 = "The operational amplifier circuit performs the mathematical operation of Differentiation, that is it “produces a voltage output which is directly proportional to the input voltage’s rate-of-change with respect to time“. In other words the faster or larger the change to the input voltage signal, the greater the input current, the greater will be the output voltage change in response, becoming more of a “spike” in shape.\n" +
                    "\n" +
                    "As with the integrator circuit, we have a resistor and capacitor forming an RC Network across the operational amplifier and the reactance ( Xc ) of the capacitor plays a major role in the performance of a Op-amp Differentiator. The input signal to the differentiator is applied to the capacitor. The capacitor blocks any DC content so there is no current flow to the amplifier summing point, X resulting in zero output voltage. The capacitor only allows AC type input voltage changes to pass through and whose frequency is dependant on the rate of change of the input signal.\n" +
                    "\n" +
                    "At low frequencies the reactance of the capacitor is “High” resulting in a low gain ( Rƒ/Xc ) and low output voltage from the op-amp. At higher frequencies the reactance of the capacitor is much lower resulting in a higher gain and higher output voltage from the differentiator amplifier.\n" +
                    "\n" +
                    "However, at high frequencies an op-amp differentiator circuit becomes unstable and will start to oscillate. This is due mainly to the first-order effect, which determines the frequency response of the op-amp circuit causing a second-order response which, at high frequencies gives an output voltage far higher than what would be expected. To avoid this the high frequency gain of the circuit needs to be reduced by adding an additional small value capacitor across the feedback resistor Rƒ.",

    THEORY_EXP_4 = "Theory of operational amplifier as integrator circuit.";

    //Theory Article urls
    private static final String
            URL_EXP_1 = "https://www.electronics-tutorials.ws/diode/diode_5.html",
            URL_EXP_2 = "https://www.electronics-tutorials.ws/diode/diode_6.html",
            URL_EXP_3 = "https://www.electronics-tutorials.ws/opamp/opamp_7.html",
            URL_EXP_4 = "https://www.electronics-tutorials.ws/opamp/opamp_6.html";
    //Circuit Diagrams
    private static final int
            CIRCUIT_EXP_1 = R.drawable.circuit1,
            CIRCUIT_EXP_2 = R.drawable.circuit2,
            CIRCUIT_EXP_3 = R.drawable.circuit3,
            CIRCUIT_EXP_4 = R.drawable.circuit4;

    //Input Waveform Images
    private static final int
            INPUT_EXP_1 = R.drawable.diode,
            INPUT_EXP_2 = R.drawable.diode,
            INPUT_EXP_3 = R.drawable.diode, //TODO since there are multiple input waveforms for op-amp exp
            INPUT_EXP_4 = R.drawable.diode; //TODO use a single image that contains all input waveforms

    //Output Waveforms Images
    private static final int
            OUTPUT_EXP_1 = R.drawable.diode,
            OUTPUT_EXP_2 = R.drawable.ac_source,
            OUTPUT_EXP_3 = R.drawable.diode, //TODO since there are multiple output waveforms for op-amp exp
            OUTPUT_EXP_4 = R.drawable.diode; //TODO use a single image that contains all output waveforms;

    //Input Graphs
    private static List<LineGraphSeries<DataPoint>> getInputGraphs(int expNumber) {
        switch (expNumber) {
            case 1:
            case 2:
                return Collections.singletonList(sineGraph());
            case 3:
                return Arrays.asList(sineGraph(), getTriangularWaveform());

        }
        return null;
    }

    //Output Graphs
    private static List<LineGraphSeries<DataPoint>> getOutputGraphs(int expNumber) {
        switch (expNumber) {
            case 1:
                return Collections.singletonList(getOutputWaveformExp1());

            case 2:
                return Collections.singletonList(getOutputWaveformExp2());

            case 3:
                return Arrays.asList(cosineGraph(), getSquareWaveform());

        }
        return null;
    }

    //Valid Connections
    private static List<Pair<Integer, Integer>> getValidConnections(int expNumber) {
        switch (expNumber) {
            case 1:
                return Arrays.asList(new Pair<>(1, 3), new Pair<>(5, 6), new Pair<>(2, 4));
            case 2:
                return Arrays.asList(new Pair<>(1, 2), new Pair<>(3, 4), new Pair<>(5, 6), new Pair<>(7, 8));
            case 3:
            case 4:
                return Arrays.asList(new Pair<>(1, 2), new Pair<>(1, 3), new Pair<>(4, 5), new Pair<>(7, 8),
                        new Pair<>(9, 10), new Pair<>(4, 6));

        }
        return null;
    }

    //Experiment Data Object
    public static ExperimentData getExperimentData(int expNumber) {
        switch (expNumber) {
            case 1:
                return new ExperimentData(expNumber, TITLE_EXP_1, AIM_EXP_1, THEORY_EXP_1, URL_EXP_1, COM_LIST_EXP_1, CIRCUIT_EXP_1, INPUT_EXP_1, OUTPUT_EXP_1,
                        getValidConnections(expNumber), getInputGraphs(expNumber), getOutputGraphs(expNumber));
            case 2:
                return new ExperimentData(expNumber, TITLE_EXP_2, AIM_EXP_2, THEORY_EXP_2, URL_EXP_2, COM_LIST_EXP_2, CIRCUIT_EXP_2, INPUT_EXP_2, OUTPUT_EXP_2,
                        getValidConnections(expNumber), getInputGraphs(expNumber), getOutputGraphs(expNumber));
            case 3:
                return new ExperimentData(expNumber, TITLE_EXP_3, AIM_EXP_3, THEORY_EXP_3, URL_EXP_3, COM_LIST_EXP_3, CIRCUIT_EXP_3, INPUT_EXP_3, OUTPUT_EXP_3,
                        getValidConnections(expNumber), getInputGraphs(expNumber), getOutputGraphs(expNumber));
            case 4:
                return new ExperimentData(expNumber, TITLE_EXP_4, AIM_EXP_4, THEORY_EXP_4, URL_EXP_4, COM_LIST_EXP_4, CIRCUIT_EXP_4, INPUT_EXP_4, OUTPUT_EXP_4,
                        getValidConnections(expNumber), getInputGraphs(expNumber), getOutputGraphs(expNumber));
        }
        return null;
    }

    //input waveform functions
    private static LineGraphSeries<DataPoint> sineGraph() {
        LineGraphSeries<DataPoint> inputGraph = new LineGraphSeries<>();
        double x, y;
        x = -stepSizeX;
        for (int i = 0; i < maxDataPoints; i++) {
            x = x + stepSizeX;
            y = Math.sin(x);
            inputGraph.appendData(new DataPoint(x, y), false, maxDataPoints);
        }
        return inputGraph;
    }

    private static LineGraphSeries<DataPoint> cosineGraph() {
        LineGraphSeries<DataPoint> inputGraph = new LineGraphSeries<>();
        double x, y;
        x = -stepSizeX;
        for (int i = 0; i < maxDataPoints; i++) {
            x = x + stepSizeX;
            y = Math.cos(x);
            inputGraph.appendData(new DataPoint(x, y), false, maxDataPoints);
        }
        return inputGraph;
    }

    //output waveform functions
    private static LineGraphSeries<DataPoint> getOutputWaveformExp1() { //half wave rectifier
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        double x, y;
        x = -stepSizeX;
        for (int i = 0; i < maxDataPoints; i++) {
            x = x + stepSizeX;
            y = Math.sin(x);
            if (y >= 0)
                series.appendData(new DataPoint(x, y), false, maxDataPoints);
        }
        return series;
    }

    private static LineGraphSeries<DataPoint> getOutputWaveformExp2() { //full wave rectifier
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        double x, y;
        x = -stepSizeX;
        for (int i = 0; i < maxDataPoints; i++) {
            x = x + stepSizeX;
            y = Math.abs(Math.sin(x));
            series.appendData(new DataPoint(x, y), false, maxDataPoints);
        }
        return series;
    }


    private static LineGraphSeries<DataPoint> getTriangularWaveform() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        double x, y;
        x = -stepSizeX;
        for (int i = 0; i < maxDataPoints; i++) {
            x += stepSizeX;
            y = (x % 2) > 1 ? 2 - (x % 2) : (x % 2);
            series.appendData(new DataPoint(x, y), false, maxDataPoints);
        }
        return series;
    }

    private static LineGraphSeries<DataPoint> getSquareWaveform() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        double x, y;
        x = -stepSizeX;
        for (int i = 0; i < maxDataPoints; i++) {
            x = x + stepSizeX;
            y = (x % 2) < 1 ? 1 : -1;
            series.appendData(new DataPoint(x, y), false, maxDataPoints);
        }
        return series;
    }

}

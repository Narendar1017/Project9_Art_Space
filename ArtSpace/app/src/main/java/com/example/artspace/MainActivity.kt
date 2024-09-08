package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceLayout(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(Color(0xFFFEFBFF))
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    )
}

@Composable
fun ArtSpaceLayout(modifier: Modifier) {
    val localDensity = LocalDensity.current
    var columnHeightDp by remember { mutableStateOf(0.dp) }

    var paintNo by remember { mutableStateOf(1) }
    var painting: Int = R.drawable._27birds_jenniferlommers_2012
    var paintingName: Int = R.string.painting1Name
    var painter: Int = R.string.painter1
    var paintYear: Int = R.string.paint1Year
    when (paintNo) {
        1 -> {
            painting = R.drawable._27birds_jenniferlommers_2012
            paintingName = R.string.painting1Name
            painter = R.string.painter1
            paintYear = R.string.paint1Year
        }
        2 -> {
            painting = R.drawable.afternoonaspengrove_garykim_2015
            paintingName = R.string.painting2Name
            painter = R.string.painter2
            paintYear = R.string.paint2Year
        }
        3 -> {
            painting = R.drawable.amomentoftranquility_luciebilodeau_2015
            paintingName = R.string.painting3Name
            painter = R.string.painter3
            paintYear = R.string.paint3Year
        }
        4 -> {
            painting = R.drawable.intermittent2_juneericavess_2019
            paintingName = R.string.painting4Name
            painter = R.string.painter4
            paintYear = R.string.paint4Year
        }
        5 -> {
            painting = R.drawable.louisianaheron_johnjamesaudubon_2011
            paintingName = R.string.painting5Name
            painter = R.string.painter5
            paintYear = R.string.paint5Year
        }
        6 -> {
            painting = R.drawable.summeronthefarm_robinmoline_2011
            paintingName = R.string.painting6Name
            painter = R.string.painter6
            paintYear = R.string.paint6Year
        }
    }
    Column(
        modifier = modifier.
            onGloballyPositioned { coridinates ->
                columnHeightDp = with(localDensity) { coridinates.size.height.toDp() }
            }
            .height(if(columnHeightDp<700.dp) 700.dp else columnHeightDp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxWidth()
                .padding(vertical = 50.dp)
                .shadow(elevation = 2.dp)
        ) {
            Image(
                painter = painterResource(painting),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 20.dp),
                contentScale = ContentScale.Fit
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFECEBF4))
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            Text(
                text = stringResource(id = paintingName),
                fontSize = 32.sp,
                fontWeight = FontWeight(300),
                lineHeight = 32.sp,
                color = Color.Black
            )
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Text(
                    text = stringResource(id = painter),
                    modifier = Modifier.padding(end = 4.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Text(
                    text = "(${stringResource(id = paintYear)})",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 24.dp, start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if(paintNo>1) paintNo-- else paintNo = 6},
                colors = ButtonColors(Color(0xFF495D92),Color.White,Color(0xFF495D92),Color.White),
                modifier = Modifier.width(130.dp)
            ) {
                Text(
                    text = "Previous",
                    fontSize = 14.sp,
                )
            }
            Button(
                onClick = { if(paintNo<6) paintNo++ else paintNo = 1},
                colors = ButtonColors(Color(0xFF495D92),Color.White,Color(0xFF495D92),Color.White),
                modifier = Modifier.width(130.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 14.sp
                )
            }
        }
    }
}